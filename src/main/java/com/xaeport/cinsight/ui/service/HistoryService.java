package com.xaeport.cinsight.ui.service;

import com.xaeport.cinsight.ui.data.entity.Condition;
import com.xaeport.cinsight.ui.data.entity.History;
import com.xaeport.cinsight.ui.data.entity.HistoryDetail;
import com.xaeport.cinsight.ui.data.mapper.HistoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * 操作记录 service
 * Created by xcp on 2017/5/27.
 */
@Service
public class HistoryService {

    @Autowired
    HistoryMapper historyMapper;

    /**
     * 查询某案件下操作记录列表
     *
     * @param caseId 案件id
     * @return
     */
    public List<History> selectHistoryList(String caseId) {
        return this.historyMapper.selectHistoryList(caseId);
    }

    /**
     * 创建操作记录
     *
     * @param history
     * @param caseId
     * @param conditions
     */
    @Transactional
    public void createHistory(History history, String caseId, List<Condition> conditions) {
        historyMapper.createHistory(history, caseId);
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
                this.historyMapper.createHistoryConditions(history.getHistoryId(), id, condition);
            }
        }

    }

    /**
     * 删除操作记录 （先删操作记录下条件，后删除操作记录）
     *
     * @param historyId 结果集id
     */
    @Transactional
    public void deleteHistory(String historyId) {
        this.historyMapper.deleteHistoryConditions(historyId);
        this.historyMapper.deleteHistory(historyId);
    }

    /**
     * 获取结果集详情
     *
     * @param historyId 结果集id
     * @return historyDetail
     */
    @Transactional
    public HistoryDetail getHistoryDetail(String historyId) {
        List<Condition> conditions = this.historyMapper.selectHistoryConditions(historyId);
        HistoryDetail historyDetail = new HistoryDetail();
        History history = this.historyMapper.selectHistoryDetail(historyId);
        historyDetail.setHistoryId(history.getHistoryId());
        historyDetail.setHistoryName(history.getHistoryName());
        historyDetail.setCreateTime(history.getCreateTime());
        historyDetail.setHistoryPage(history.getHistoryPage());
        historyDetail.setDetailId(history.getDetailId());
        historyDetail.setConditions(conditions);
        return historyDetail;
    }

}
