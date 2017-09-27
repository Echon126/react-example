package com.xaeport.cinsight.ui.controller;


import com.alibaba.druid.util.StringUtils;
import com.xaeport.cinsight.ui.api.CaseApi;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
import com.xaeport.cinsight.ui.data.api.model.InlineResponse200;
import com.xaeport.cinsight.ui.data.entity.CaseInfo;
import com.xaeport.cinsight.ui.service.CaseService;
import com.xaeport.cinsight.ui.tools.DateUtils;
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
import java.text.ParseException;
import java.util.List;
import java.util.UUID;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class CaseApiController implements CaseApi {

    @Autowired
    CaseService caseService;

    private Log log = LogFactory.getLog(this.getClass());

    private com.xaeport.cinsight.ui.engine.api.CaseApi caseApiClient = new com.xaeport.cinsight.ui.engine.api.CaseApi();

    public ResponseEntity<Object> createCase(@NotNull @ApiParam(value = "案件编号（唯一）", required = true) @RequestParam(value = "caseCode", required = true) String caseCode,
                                             @NotNull @ApiParam(value = "案件名称", required = true) @RequestParam(value = "caseName", required = true) String caseName,
                                             @NotNull @ApiParam(value = "负责人", required = true) @RequestParam(value = "caseOperator", required = true) String caseOperator,
                                             @NotNull @ApiParam(value = "立案日期", required = true) @RequestParam(value = "kickoffDate", required = true) String kickoffDate,
                                             @ApiParam(value = "备注") @RequestParam(value = "remark", required = false) String remark) {
        boolean isError = false;
        ResponseData responseData = new ResponseData();
        Object obj = new Object();
        int caseIdIsExist = this.caseService.checkCaseCodeCount(caseCode);

        // caseId 已存在
        if (caseIdIsExist > 0) {
            responseData.setMessage("案件ID重复");
            return new ResponseEntity(responseData, HttpStatus.BAD_REQUEST);
        }

        CaseInfo caseInfo = new CaseInfo();
        String caseId = UUID.randomUUID().toString();
        caseInfo.setCaseId(caseId);
        caseInfo.setCaseCode(caseCode);
        caseInfo.setCaseName(caseName);
        caseInfo.setCaseOperator(caseOperator);
        try {
            caseInfo.setKickoffDate(DateUtils.dateStrToTimestamp(kickoffDate));
        } catch (ParseException e) {
            caseInfo.setKickoffDate(System.currentTimeMillis());
            this.log.error("createCase 立案日期转换失败 kickoffDate=" + kickoffDate, e);
        }
        caseInfo.setLastViewTime(System.currentTimeMillis());
        // 初始化邮件数为 0
        caseInfo.setMailAmount(0);
        caseInfo.setRemark(remark);
        try {
            // 调用api 创建案件
            this.caseApiClient.createCase(caseId);
            // 本地数据库 保存创建案件
            this.caseService.createCase(caseInfo);
        } catch (ApiException e) {
            isError = true;
            this.log.error("createCase api 调用失败", e);
            responseData.setMessage("创建案件API 调用失败");
            if (e.getResponseBody() != null) {
                obj = e.getResponseBody();
            } else {
                obj = responseData;
            }
        } catch (Exception s) {
            isError = true;
            this.log.error("createCase 本地数据库操作失败", s);
            responseData.setMessage("本地数据库 操作异常");
            obj = responseData;
        }
        if (isError) {
            return new ResponseEntity(obj, HttpStatus.BAD_REQUEST);
        } else {
              return new ResponseEntity(caseInfo, HttpStatus.OK);
        }
    }

    public ResponseEntity<Object> activateCase(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        this.log.info("激活案件 = " + caseId);
        boolean isError = false;
        Object obj = new Object();
        ResponseData responseData = new ResponseData();
        try {
            // 调用api 激活案件
            this.caseApiClient.activateCaseById(caseId);
        } catch (ApiException e) {
            isError = true;
            this.log.error("activateCase api 调用失败", e);
            responseData.setMessage("激活案件API 调用失败");
            if (e.getResponseBody() != null) {
                obj = e.getResponseBody();
            } else {
                obj = responseData;
            }
        }
        if (isError) {
            return new ResponseEntity(obj, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }


    public ResponseEntity<Object> deleteCase
            (@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        this.log.info("案件删除：caseId=" + caseId);
        boolean isError = false;
        Object obj;
        ResponseData responseData = new ResponseData();
        try {
            // 调用api 删除案件
            this.caseApiClient.deleteCaseById(caseId);
            // 本地数据库 保存删除案件
            this.caseService.deleteCaseByCaseId(caseId);
        } catch (ApiException e) {
            isError = true;
            this.log.error("deleteCaseById api 调用失败", e);
            responseData.setMessage("删除案件API 调用失败");
            if (e.getResponseBody() != null) {
                obj = e.getResponseBody();
            } else {
                obj = responseData;
            }
        } catch (Exception s) {
            isError = true;
            this.log.error("createCase 本地数据库操作失败", s);
            responseData.setMessage("本地数据库操作异常");
            obj = responseData;
        }

        if (isError) {
            return new ResponseEntity(responseData, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }

    }

    public ResponseEntity<InlineResponse200> generatorCaseCode() {
        InlineResponse200 obj = new InlineResponse200();
        String maxCaseCode = this.caseService.selectMaxCaseCode();
        String caseCode = "AJ0001";
        if (!StringUtils.isEmpty(maxCaseCode) && maxCaseCode.length() == 6) {
            String caseCodeStr = maxCaseCode.substring(2, maxCaseCode.length());
            int maxCode = Integer.parseInt(caseCodeStr);
            maxCode = maxCode + 1;
            caseCode = "AJ" + this.zerofill(String.valueOf(maxCode), 4);
        }
        obj.setCaseCode(caseCode);
        this.log.info("自动生成的caseCode=" + caseCode);
        return new ResponseEntity<InlineResponse200>(obj, HttpStatus.OK);
    }

    /**
     * 数字补零
     *
     * @param numStr 数字字符串
     * @param count  总需要位数
     * @return
     */

    private String zerofill(String numStr, int count) {
        int length = numStr.length();
        if (length < count) {
            String fill = "";
            for (int i = 0; i < count - length; i++) {
                fill += "0";
            }
            numStr = fill + numStr;
        }
        return numStr;
    }

    public ResponseEntity<List<CaseInfo>> selectCaseList() {
        boolean isError = false;
        List<CaseInfo> localCaseInfoList = null;
        List<com.xaeport.cinsight.ui.engine.model.CaseInfo> apiCaseInfoList = null;
        try {
            // 调用api 查询案件列表信息
            apiCaseInfoList = this.caseApiClient.listCase();
            // 本地数据库 查询案件列表信息
            localCaseInfoList = this.caseService.selectCaseList();
            for (int i = 0; i < apiCaseInfoList.size(); i++) {
                for (int j = 0; j < localCaseInfoList.size(); j++) {
                    if ((apiCaseInfoList.get(i).getCaseId()).equals(localCaseInfoList.get(j).getCaseId())) {
                        localCaseInfoList.get(j).setMailAmount(apiCaseInfoList.get(i).getMailAmount());
                    }
                }
            }
        } catch (ApiException e) {
            isError = true;
            this.log.error("listCase api 调用失败", e);
        } catch (Exception e) {
            isError = true;
            this.log.error("selectCaseList 本地数据库操作失败", e);
        }

        if (isError) {
            return new ResponseEntity<List<CaseInfo>>(localCaseInfoList, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<List<CaseInfo>>(localCaseInfoList, HttpStatus.OK);
        }

    }

    public ResponseEntity<Object> updateCase(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                             @NotNull @ApiParam(value = "案件名称", required = true) @RequestParam(value = "caseName", required = true) String caseName,
                                             @NotNull @ApiParam(value = "负责人", required = true) @RequestParam(value = "caseOperator", required = true) String caseOperator,
                                             @NotNull @ApiParam(value = "立案日期", required = true) @RequestParam(value = "kickoffDate", required = true) String kickoffDate,
                                             @ApiParam(value = "备注") @RequestParam(value = "remark", required = false) String remark) {
        this.log.info("案件修改：caseId=" + caseId + "caseName=" + caseName + "caseOperator=" + caseOperator + "kickoffDate=" + kickoffDate + "remark=" + remark);
        boolean isError = false;
        ResponseData responseData = new ResponseData();

        CaseInfo caseInfo = new CaseInfo();
        caseInfo.setCaseId(caseId);
        caseInfo.setCaseName(caseName);
        caseInfo.setCaseOperator(caseOperator);
        try {
            caseInfo.setKickoffDate(DateUtils.dateStrToTimestamp(kickoffDate));
        } catch (ParseException e) {
            caseInfo.setKickoffDate(System.currentTimeMillis());
            this.log.error("createCase 立案日期转换失败 kickoffDate=" + kickoffDate, e);
        }
        caseInfo.setLastViewTime(System.currentTimeMillis());
        caseInfo.setRemark(remark);
        try {
            this.caseService.updateCase(caseInfo);
        } catch (Exception e) {
            isError = true;
            responseData.setMessage("案件修改本地数据库操作异常");
            this.log.info("updateCase 本地数据库操作失败", e);
        }

        if (isError) {
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Object>(HttpStatus.OK);
        }

    }


}
