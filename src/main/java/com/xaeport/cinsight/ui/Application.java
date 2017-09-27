package com.xaeport.cinsight.ui;

import com.xaeport.cinsight.ui.configuration.AppConfiguration;
import com.xaeport.cinsight.ui.data.source.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Created by xcp on 2016/10/24.
 */
@SpringBootApplication
@Import({DynamicDataSourceRegister.class})
@ServletComponentScan
@EnableAutoConfiguration(exclude = {MultipartAutoConfiguration.class})
public class Application {

    public static void main(String[] args) {
        AppConfiguration.setBaseFolder(Application.class);
        SpringApplication.run(Application.class);
    }
}
