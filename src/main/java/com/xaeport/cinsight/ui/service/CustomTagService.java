package com.xaeport.cinsight.ui.service;

import com.xaeport.cinsight.ui.data.entity.CustomTag;
import com.xaeport.cinsight.ui.data.mapper.CustomTagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签 service
 * Created by xcp on 2017/5/27.
 */
@Service
public class CustomTagService {

    @Autowired
    CustomTagMapper customTagMapper;

    /**
     * 查询插件配置列表
     *
     * @return
     */
    public List<CustomTag> selectCustomTagList() {
        return this.customTagMapper.selectCustomTagList();
    }


    /**
     * 删除自定义标签
     */
    public void deleteCustomTagByTagId(String tagId) {
        this.customTagMapper.deleteCustomTagByTagId(tagId);
    }

    /**
     * 创建自定义标签
     *
     * @param customTag
     */
    public void createCustomTag(CustomTag customTag) {
        this.customTagMapper.createCustomTag(customTag);
    }

    /**
     * 检查自定义标签名重复
     *
     * @param tagName 自定义标签名
     * @return
     */
    public int checkTagNameCount(String tagName) {
        return this.customTagMapper.checkTagNameCount(tagName);
    }


}
