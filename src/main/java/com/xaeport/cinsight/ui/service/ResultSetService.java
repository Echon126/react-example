package com.xaeport.cinsight.ui.service;

import com.xaeport.cinsight.ui.data.entity.Condition;
import com.xaeport.cinsight.ui.data.entity.ResultSet;
import com.xaeport.cinsight.ui.data.entity.ResultSetDetail;
import com.xaeport.cinsight.ui.data.mapper.ResultSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 结果集 service
 * Created by xcp on 2017/5/26.
 */
@Service
public class ResultSetService {

    @Autowired
    ResultSetMapper resultSetMapper;

    /**
     * 查询某案件下结果集列表
     *
     * @param caseId 案件id
     * @return
     */
    public List<ResultSet> selectResultSetList(String caseId) {
        return this.resultSetMapper.selectResultSetList(caseId);
    }

    /**
     * 创建结果集
     *
     * @param resultSetId   结果集id
     * @param resultSetName 结果集名称
     * @param createTime    创建时间
     * @param caseId        案件id
     */
    @Transactional
    public void createResultSet(String resultSetId, String resultSetName, String resultSetToken, Long createTime, String caseId, List<Condition> conditions) {
        resultSetMapper.createResultSet(resultSetId, resultSetName, resultSetToken, createTime, caseId);
        if (!CollectionUtils.isEmpty(conditions)) {
            Condition condition;
            Map map;
            String id;
            for (int i = 0; i < conditions.size(); i++) {
                condition = new Condition();
                id = UUID.randomUUID().toString();
                map = (Map) conditions.get(i);
                condition.setRelation((String) map.get("relation"));
                condition.setKeyword((String) map.get("keyword"));
                condition.setExpression((String) map.get("expression"));
                condition.setResult((String) map.get("result"));
                this.resultSetMapper.createResultSetConditions(resultSetId, id, condition);
            }
        }

    }

    /**
     * 删除结果集 （先删结果集下条件，后删除结果集）
     *
     * @param resultSetId 结果集id
     */
    @Transactional
    public void deleteResultSet(String resultSetId) {
        this.resultSetMapper.deleteResultSetConditions(resultSetId);
        this.resultSetMapper.deleteResultSet(resultSetId);
    }

    /**
     * 获取结果集详情
     *
     * @param resultSetId 结果集id
     * @return resultSetDetail
     */
    @Transactional
    public ResultSetDetail getResultSetDetail(String resultSetId) {
        ResultSet resultSet = this.resultSetMapper.selectResultSetDetail(resultSetId);
        List<Condition> conditions = this.resultSetMapper.selectResultSetConditions(resultSetId);
        ResultSetDetail resultSetDetail = new ResultSetDetail();
        resultSetDetail.setResultsetId(resultSetId);
        resultSetDetail.setResultsetName(resultSet.getResultsetName());
        resultSetDetail.setResultsetToken(resultSet.getResultsetToken());
        resultSetDetail.setConditions(conditions);
        return resultSetDetail;
    }

}
