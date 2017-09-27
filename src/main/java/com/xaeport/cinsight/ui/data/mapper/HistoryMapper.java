package com.xaeport.cinsight.ui.data.mapper;

import com.xaeport.cinsight.ui.data.entity.Condition;
import com.xaeport.cinsight.ui.data.entity.History;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 操作记录
 * Created by xcp on 2017/5/27.
 */
@Mapper
public interface HistoryMapper {

    /**
     * 查询操作记录列表（TOP1000，时间倒序）
     */
    @Select("select * from ci_history where caseId = #{caseId} order by createTime desc limit 1000")
    List<History> selectHistoryList(@Param("caseId") String caseId);

    /**
     * 查询操作记录详情
     */
    @Select("select * from ci_history where historyId = #{historyId}")
    History selectHistoryDetail(@Param("historyId") String historyId);

    /**
     * 删除操作记录
     */
    @Delete("delete from ci_history where historyId = #{historyId} ")
    void deleteHistory(@Param("historyId") String historyId);

    /**
     * 删除操作记录条件
     */
    @Delete("delete from ci_his_condition where historyId = #{historyId} ")
    void deleteHistoryConditions(@Param("historyId") String historyId);


    /**
     * 新增操作记录
     */
    @Insert("insert into ci_history(historyId,historyName,createTime,historyPage,detailId,caseId) values(#{history.historyId},#{history.historyName},#{history.createTime},#{history.historyPage},#{history.detailId},#{caseId})")
    void createHistory(@Param("history") History history, @Param("caseId") String caseId);


    /**
     * 新增操作记录条件
     */
    @Insert("insert into ci_his_condition(id,relation,keyword,expression,result,historyId) values(#{id},#{condition.relation},#{condition.keyword},#{condition.expression},#{condition.result},#{resultSetId});")
    void createHistoryConditions(@Param("historyId") String historyId, @Param("id") String id, @Param("condition") Condition condition);


    /**
     * 查询某个操作记录的条件集合
     */
    @Select("select * from ci_his_condition where historyId = #{historyId}")
    List<Condition> selectHistoryConditions(@Param("historyId") String historyId);
}
