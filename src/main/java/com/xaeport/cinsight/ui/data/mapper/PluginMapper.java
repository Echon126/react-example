package com.xaeport.cinsight.ui.data.mapper;

import com.xaeport.cinsight.ui.data.entity.Plugin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 插件
 * Created by xcp on 2017/5/27.
 */
@Mapper
public interface PluginMapper {

    /**
     * 查询插件列表
     */
    @Select("select * from ci_plugin order by createTime desc")
    List<Plugin> selectPluginList();


    /**
     * 修改插件选中状态
     */
    @Update(" update ci_plugin set pluginEnabled=#{pluginEnabled} where pluginId=#{pluginId} ")
    void updatePluginEnabled(@Param("pluginId") String pluginId, @Param("pluginEnabled") int pluginEnabled);


    /**
     * 删除插件
     */
    @Delete("delete from ci_plugin where pluginId = #{pluginId} ")
    void deletePluginByPluginId(@Param("pluginId") String pluginId);


    /**
     * 新建插件
     */
    @Insert("insert into ci_plugin(pluginId,pluginName,pluginDescription,pluginEnabled,createTime) values(#{plugin.pluginId},#{plugin.pluginName},#{plugin.pluginDescription},#{plugin.pluginEnabled},#{plugin.createTime})")
    void createPlugin(@Param("plugin") Plugin plugin);


}
