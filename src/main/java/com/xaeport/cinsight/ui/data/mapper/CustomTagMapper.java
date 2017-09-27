package com.xaeport.cinsight.ui.data.mapper;

import com.xaeport.cinsight.ui.data.entity.CustomTag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 标签
 * Created by xcp on 2017/5/31.
 */
@Mapper
public interface CustomTagMapper {

    /**
     * 查询自定义标签列表
     */
    @Select("select * from ci_tag order by frequency,lastUseTime desc")
    List<CustomTag> selectCustomTagList();


    /**
     * 删除自定义变迁
     */
    @Delete("delete from ci_tag where tagId = #{tagId} ")
    void deleteCustomTagByTagId(@Param("tagId") String tagId);


    /**
     * 新建自定义标签
     */
    @Insert("insert into ci_tag(tagId,tagName,tagIcon,frequency,createTime,lastUseTime) values(#{customTag.tagId},#{customTag.tagName},#{customTag.tagIcon},#{customTag.frequency},#{customTag.createTime},#{customTag.lastUseTime});")
    void createCustomTag(@Param("customTag") CustomTag customTag);


    /**
     * 查询自定义标签是否可用
     */
    @Select("select count(*) from ci_tag where tagName=#{tagName}")
    int checkTagNameCount(@Param("tagName") String tagName);
}
