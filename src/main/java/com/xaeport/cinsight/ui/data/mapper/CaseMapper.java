package com.xaeport.cinsight.ui.data.mapper;

import com.xaeport.cinsight.ui.data.entity.CaseInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 案件
 * Created by xcp on 2017/5/26.
 */
@Mapper
public interface CaseMapper {

    /**
     * 查询案件列表
     */
    @Select("select * from ci_case order by lastViewTime desc limit 100")
    List<CaseInfo> selectCaseList();

    /**
     * 删除案件
     */
    @Delete("delete from ci_case where caseId = #{caseId} ")
    void deleteCaseByCaseId(@Param("caseId") String caseId);


    /**
     * 新建案件,返回主键
     */
    @Insert("insert into ci_case(caseId,caseCode,caseName,caseOperator,kickoffDate,lastViewTime,mailAmount,remark) values(#{caseInfo.caseId},#{caseInfo.caseCode},#{caseInfo.caseName},#{caseInfo.caseOperator},#{caseInfo.kickoffDate},#{caseInfo.lastViewTime},#{caseInfo.mailAmount},#{caseInfo.remark})")
   /* @Options(useGeneratedKeys = true, keyProperty = "caseInfo.caseId")*/
    void createCase(@Param("caseInfo") CaseInfo caseInfo);


    /**
     * 编辑案件
     */
    @Update(" update ci_case set caseName=#{caseInfo.caseName},caseOperator=#{caseInfo.caseOperator},kickoffDate=#{caseInfo.kickoffDate},lastViewTime=#{caseInfo.lastViewTime},remark=#{caseInfo.remark} where caseId=#{caseInfo.caseId} ")
    void updateCase(@Param("caseInfo") CaseInfo caseInfo);


    /**
     * 查询案件编号是否可用
     */
    @Select("select count(*) from ci_case where caseCode=#{caseCode}")
    int checkCaseCodeCount(@Param("caseCode") String caseCode);


    /**
     * 查询最大案件编号
     *
     * @return 最大的caseCode
     */
    @Select("select caseCode from ci_case where caseCode like 'AJ____'  order by caseCode desc limit 1")
    String selectMaxCaseCode();
}
