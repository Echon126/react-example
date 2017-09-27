package com.xaeport.cinsight.ui.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.xaeport.cinsight.ui.api.ResultsetApi;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
import com.xaeport.cinsight.ui.data.entity.Condition;
import com.xaeport.cinsight.ui.data.entity.ResultSet;
import com.xaeport.cinsight.ui.data.entity.ResultSetDetail;
import com.xaeport.cinsight.ui.service.ResultSetService;
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
public class ResultsetApiController implements ResultsetApi {

    @Autowired
    ResultSetService resultSetService;

    private Log log = LogFactory.getLog(this.getClass());

    private com.xaeport.cinsight.ui.engine.api.ResultsetApi resultsetApiClient = new com.xaeport.cinsight.ui.engine.api.ResultsetApi();

    public ResponseEntity<Object> createResultSet(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                  @NotNull @ApiParam(value = "结果集名称", required = true) @RequestParam(value = "resultsetName", required = true) String resultsetName,
                                                  @NotNull @ApiParam(value = "结果集token", required = true) @RequestParam(value = "resultsetToken", required = true) String resultsetToken,
                                                  @NotNull @ApiParam(value = "检索条件", required = true) @RequestParam(value = "conditions", required = true) String conditions) {
        ResponseData responseData = new ResponseData();
        List<Condition> conditionList = (List<Condition>) ((Map) JSONUtils.parse(conditions)).get("conditions");
        try {
            responseData = (ResponseData) resultsetApiClient.createResultSet(resultsetToken);
            String resultSetId = UUID.randomUUID().toString();
            this.resultSetService.createResultSet(resultSetId, resultsetName, resultsetToken, System.currentTimeMillis(), caseId, conditionList);
        } catch (ApiException api) {
            this.log.error("createResultSet API 调用失败 caseId=" + caseId + ",resultsetName=" + resultsetName + ",resultsetToken=" + resultsetToken, api);
            return new ResponseEntity<Object>(api.getResponseBody(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            this.log.error("本地数据库新增结果集失败 caseId=" + caseId + ",resultsetName=" + resultsetName + ",resultsetToken=" + resultsetToken, e);
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> deleteResultSet(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                  @ApiParam(value = "结果集id", required = true) @PathVariable("resultsetId") String resultsetId) {
        ResponseData responseData = new ResponseData();
        try {
            this.resultSetService.deleteResultSet(resultsetId);
        } catch (Exception e) {
            this.log.error("本地数据库删除结果集失败 resultsetId=" + resultsetId);
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> getResultSetDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                     @ApiParam(value = "结果集id", required = true) @PathVariable("resultsetId") String resultsetId) {
        ResultSetDetail resultSetDetail = null;
        ResponseData responseData = new ResponseData();
        try {
            resultSetDetail = this.resultSetService.getResultSetDetail(resultsetId);
        } catch (Exception e) {
            this.log.error("本地数据库查询结果集详情失败 caseId=" + caseId);
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(resultSetDetail, HttpStatus.OK);
    }

    public ResponseEntity<List<ResultSet>> selectResultSetList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        List<ResultSet> list = null;
        try {
            list = this.resultSetService.selectResultSetList(caseId);
        } catch (Exception e) {
            this.log.error("本地数据库查询结果集列表失败 caseId=" + caseId);
            return new ResponseEntity<List<ResultSet>>(list, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<ResultSet>>(list, HttpStatus.OK);
    }

}
