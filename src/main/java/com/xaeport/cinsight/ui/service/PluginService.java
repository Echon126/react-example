package com.xaeport.cinsight.ui.service;

import com.xaeport.cinsight.ui.data.entity.Plugin;
import com.xaeport.cinsight.ui.data.mapper.PluginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 插件 service
 * Created by xcp on 2017/5/27.
 */
@Service
public class PluginService {

    @Autowired
    PluginMapper pluginMapper;

    /**
     * 查询插件配置列表
     *
     * @return
     */
    public List<Plugin> selectPluginList() {
        return this.pluginMapper.selectPluginList();
    }

    /**
     * 修改插件配置 选中/不选
     *
     * @param pluginList
     */
    public void updatePluginEnabled(List<Plugin> pluginList) {
        for (int i = 0; i < pluginList.size(); i++) {
            this.pluginMapper.updatePluginEnabled(pluginList.get(i).getPluginId(), pluginList.get(i).getPluginEnabled() == true ? 1 : 0);
        }
    }


}
