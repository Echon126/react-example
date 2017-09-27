package com.xaeport.cinsight.ui.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.xaeport.cinsight.ui.api.HistoryApi;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
import com.xaeport.cinsight.ui.data.entity.Condition;
import com.xaeport.cinsight.ui.data.entity.History;
import com.xaeport.cinsight.ui.data.entity.HistoryDetail;
import com.xaeport.cinsight.ui.service.HistoryService;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class HistoryApiController implements HistoryApi {

    @Autowired
    HistoryService historyService;

    private Log log = LogFactory.getLog(this.getClass());

    public ResponseEntity<Object> createHistory(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                @NotNull @ApiParam(value = "操作记录名称", required = true) @RequestParam(value = "historyName", required = true) String historyName,
                                                @NotNull @ApiParam(value = "操作界面", required = true) @RequestParam(value = "historyPage", required = true) String historyPage,
                                                @NotNull @ApiParam(value = "详情id", required = true) @RequestParam(value = "detailId", required = true) String detailId,
                                                @NotNull @ApiParam(value = "检索条件", required = true) @RequestParam(value = "conditions", required = true) String conditions) {

        this.log.info("新增操作记录：caseId=" + caseId + " -historyName=" + historyName + " -historyPage=" + historyPage + " -detailId=" + detailId + " -conditions=" + conditions);
        ResponseData responseData = new ResponseData();
        List<Condition> conditionList = (List<Condition>) ((Map) JSONUtils.parse(conditions)).get("conditions");
        History history = new History();
        history.setHistoryId(UUID.randomUUID().toString());
        history.setHistoryName(historyName);
        history.setHistoryPage(historyPage);
        history.setDetailId(detailId);
        try {
            this.historyService.createHistory(history, caseId, conditionList);
        } catch (Exception e) {
            this.log.error("本地数据库新增操作记录失败 caseId=" + caseId, e);
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteHistory(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                @ApiParam(value = "操作记录id", required = true) @PathVariable("historyId") String historyId) {
        ResponseData responseData = new ResponseData();
        try {
            this.historyService.deleteHistory(historyId);
        } catch (Exception e) {
            this.log.error("本地数据库删除操作记录失败 historyId=" + historyId);
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> getHistoryDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                   @ApiParam(value = "操作记录id", required = true) @PathVariable("historyId") String historyId) {
        HistoryDetail historyDetail = null;
        ResponseData responseData = new ResponseData();
        try {
            historyDetail = this.historyService.getHistoryDetail(historyId);
        } catch (Exception e) {
            this.log.error("本地数据库查询操作记录详情失败 caseId=" + caseId);
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(historyDetail, HttpStatus.OK);
    }

    public ResponseEntity<List<History>> selectHistoryList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        List<History> list = null;
        try {
            list = this.historyService.selectHistoryList(caseId);
        } catch (Exception e) {
            this.log.error("本地数据库查询操作记录列表失败 caseId=" + caseId);
            return new ResponseEntity<List<History>>(list, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<History>>(list, HttpStatus.OK);
    }

}
