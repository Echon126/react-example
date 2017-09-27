package com.xaeport.cinsight.ui.data.source;

import com.xaeport.cinsight.ui.configuration.AppConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.bind.RelaxedDataBinder;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotationMetadata;

import javax.sql.DataSource;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 动态数据源注册
 * Created by xcp on 2017/4/7.
 */
public class DynamicDataSourceRegister implements ImportBeanDefinitionRegistrar, EnvironmentAware {

    private static final Object DATASOURCE_TYPE_DEFAULT = "com.alibaba.druid.pool.DruidDataSource";

    private ConversionService conversionService = new DefaultConversionService();

    private PropertyValues dataSourcePropertyValues;

    private Log log = LogFactory.getLog(this.getClass());
    // 默认数据源
    private DataSource defaultDataSource;

    private Map<String, DataSource> customDataSources = new HashMap<>();

    @Override
    public void setEnvironment(Environment environment) {
        this.log.debug("DynamicDataSourceRegister.setEnvironment()");

        initDefaultDataSource(environment);

        initCustomDataSources(environment);
    }

    /**
     * 加载主数据源配置.
     */
    private void initDefaultDataSource(Environment env) {
        // 读取主数据源
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "spring.datasource.");

        Map<String, Object> dsMap = new HashMap<>();
        dsMap.put("type", propertyResolver.getProperty("type"));
        dsMap.put("driverClassName", propertyResolver.getProperty("driverClassName"));
        dsMap.put("url", "jdbc:sqlite://" + AppConfiguration.getBaseFolder().getAbsolutePath() + File.separator + "db" + File.separator + propertyResolver.getProperty("name"));
        dsMap.put("username", propertyResolver.getProperty("username"));
        dsMap.put("password", propertyResolver.getProperty("password"));
        dsMap.put("dbType", propertyResolver.getProperty("dbType"));

        //创建数据源;
        defaultDataSource = buildDataSource(dsMap);
        dataBinder(defaultDataSource, env);
    }

    /**
     * 初始化更多数据源
     */
    private void initCustomDataSources(Environment env) {

        // 读取配置文件获取更多数据源，也可以通过defaultDataSource读取数据库获取更多数据源
        RelaxedPropertyResolver propertyResolver = new RelaxedPropertyResolver(env, "custom.datasource.");
        String dsPrefixs = propertyResolver.getProperty("names");
        for (String dsPrefix : dsPrefixs.split(",")) {// 多个数据源

            Map<String, Object> dsMap = propertyResolver.getSubProperties(dsPrefix + ".");

            DataSource ds = buildDataSource(dsMap);

            customDataSources.put(dsPrefix, ds);

            dataBinder(ds, env);

        }

    }


    private DataSource buildDataSource(Map<String, Object> dsMap) {
        Object type = dsMap.get("type");
        if (type == null) {
            type = DATASOURCE_TYPE_DEFAULT;// 默认DataSource
        }
        Class<? extends DataSource> dataSourceType;
        try {
            dataSourceType = (Class<? extends DataSource>) Class.forName((String) type);
            String driverClassName = dsMap.get("driverClassName").toString();
            String url = dsMap.get("url").toString();
            String username = dsMap.get("username").toString();
            String password = dsMap.get("password").toString();
            DataSourceBuilder factory = DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username).password(password).type(dataSourceType);
            return factory.build();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 为DataSource绑定更多数据
     */
    private void dataBinder(DataSource dataSource, Environment env) {
        RelaxedDataBinder dataBinder = new RelaxedDataBinder(dataSource);
        dataBinder.setConversionService(conversionService);
        dataBinder.setIgnoreNestedProperties(false);//false
        dataBinder.setIgnoreInvalidFields(false);//false
        dataBinder.setIgnoreUnknownFields(true);//true
        if (dataSourcePropertyValues == null) {
            Map<String, Object> rpr = new RelaxedPropertyResolver(env, "spring.datasource").getSubProperties(".");
            Map<String, Object> values = new HashMap<>(rpr);
            // 排除已经设置的属性
            values.remove("type");
            values.remove("driverClassName");
            values.remove("url");
            values.remove("username");
            values.remove("password");
            dataSourcePropertyValues = new MutablePropertyValues(values);
        }
        dataBinder.bind(dataSourcePropertyValues);
    }


    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        this.log.debug("DynamicDataSourceRegister.registerBeanDefinitions()");
        Map<Object, Object> targetDataSources = new HashMap<>();
        // 将主数据源添加到更多数据源中
        targetDataSources.put("dataSource", defaultDataSource);
        DynamicDataSourceContextHolder.dataSourceIds.add("dataSource");
        // 添加更多数据源
        targetDataSources.putAll(customDataSources);
        for (String key : customDataSources.keySet()) {
            DynamicDataSourceContextHolder.dataSourceIds.add(key);
        }
        // 创建DynamicDataSource
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(DynamicDataSource.class);
        beanDefinition.setSynthetic(true);
        MutablePropertyValues mpv = beanDefinition.getPropertyValues();
        //添加属性：AbstractRoutingDataSource.defaultTargetDataSource
        mpv.addPropertyValue("defaultTargetDataSource", defaultDataSource);
        mpv.addPropertyValue("targetDataSources", targetDataSources);
        registry.registerBeanDefinition("dataSource", beanDefinition);
    }

}
