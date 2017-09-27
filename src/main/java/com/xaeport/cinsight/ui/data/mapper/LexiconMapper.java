package com.xaeport.cinsight.ui.data.mapper;

import com.xaeport.cinsight.ui.data.entity.Lexicon;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 词库
 * Created by xcp on 2017/5/27.
 */
@Mapper
public interface LexiconMapper {

    /**
     * 查询插件列表
     */
    @Select("select * from ci_lexicon order by createTime desc")
    List<Lexicon> selectLexiconList();


    /**
     * 修改插件选中状态
     */
    @Update(" update ci_lexicon set lexiconEnabled=#{lexiconEnabled} where lexiconId=#{lexiconId} ")
    void updateLexiconEnabled(@Param("lexiconId") String lexiconId, @Param("lexiconEnabled") int lexiconEnabled);


    /**
     * 删除插件
     */
    @Delete("delete from ci_lexicon where lexiconId = #{lexiconId} ")
    void deleteLexiconByLexiconId(@Param("lexiconId") String lexiconId);


    /**
     * 新建插件
     */
    @Insert("insert into ci_lexicon(lexiconId,lexiconName,lexiconDescription,lexiconEnabled,createTime) values(#{lexicon.lexiconId},#{lexicon.lexiconName},#{lexicon.lexiconDescription},#{lexicon.lexiconEnabled},#{lexicon.createTime})")
    void createLexicon(@Param("Lexicon") Lexicon Lexicon);


}
