package com.xaeport.cinsight.ui.data.mapper;

import com.xaeport.cinsight.ui.data.entity.Condition;
import com.xaeport.cinsight.ui.data.entity.ResultSet;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 结果集
 * Created by xcp on 2017/5/26.
 */
@Mapper
public interface ResultSetMapper {

    /**
     * 查询结果集列表（TOP1000，时间倒序）
     */
    @Select("select * from ci_result_set where caseId = #{caseId} order by createTime desc limit 1000")
    List<ResultSet> selectResultSetList(@Param("caseId") String caseId);

    /**
     * 删除结果集
     */
    @Delete("delete from ci_result_set where resultSetId = #{resultSetId} ")
    void deleteResultSet(@Param("resultSetId") String resultSetId);

    /**
     * 删除结果集条件
     */
    @Delete("delete from ci_rs_condition where resultSetId = #{resultSetId} ")
    void deleteResultSetConditions(@Param("resultSetId") String resultSetId);


    /**
     * 新增结果集
     */
    @Insert("insert into ci_result_set(resultSetId,resultSetName,resultSetToken,createTime,caseId) values(#{resultSetId},#{resultSetName},#{resultSetToken},#{createTime},#{caseId})")
    void createResultSet(@Param("resultSetId") String resultSetId, @Param("resultSetName") String resultSetName, @Param("resultSetToken") String resultSetToken, @Param("createTime") Long createTime, @Param("caseId") String caseId);


    /**
     * 新增结果集内条件
     */
    @Insert("insert into ci_rs_condition(id,relation,keyword,expression,result,resultSetId) values(#{id},#{condition.relation},#{condition.keyword},#{condition.expression},#{condition.result},#{resultSetId});")
    void createResultSetConditions(@Param("resultSetId") String resultSetId, @Param("id") String id, @Param("condition") Condition condition);

    /**
     * 查询结果集详情
     */
    @Select("select * from ci_result_set where resultSetId = #{resultSetId}")
    ResultSet selectResultSetDetail(@Param("resultSetId") String resultSetId);


    /**
     * 查询某个结果集的条件集合
     */
    @Select("select * from ci_rs_condition where resultSetId = #{resultSetId}")
    List<Condition> selectResultSetConditions(@Param("resultSetId") String resultSetId);
}
