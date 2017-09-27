package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.api.model.InlineResponse200;
import com.xaeport.cinsight.ui.data.entity.CaseInfo;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-26T07:27:07.083Z")
@RequestMapping(value = "/v10")
@Api(value = "case", description = "the case API")
public interface CaseApi {

    @ApiOperation(value = "案件激活", notes = "案件激活（激活引擎案件切换）", response = Object.class, tags = {"case",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/case/activate/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Object> activateCase(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);


    @ApiOperation(value = "新建案件", notes = "新建案件", response = Object.class, tags = {"case",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/case",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Object> createCase(@NotNull @ApiParam(value = "案件编号（唯一）", required = true) @RequestParam(value = "caseCode", required = true) String caseCode,
                                      @NotNull @ApiParam(value = "案件名称", required = true) @RequestParam(value = "caseName", required = true) String caseName,
                                      @NotNull @ApiParam(value = "负责人", required = true) @RequestParam(value = "caseOperator", required = true) String caseOperator,
                                      @NotNull @ApiParam(value = "立案日期", required = true) @RequestParam(value = "kickoffDate", required = true) String kickoffDate,
                                      @ApiParam(value = "备注") @RequestParam(value = "remark", required = false) String remark);


    @ApiOperation(value = "删除案件", notes = "删除案件", response = Object.class, tags = {"case",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/case/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.DELETE)
    ResponseEntity<Object> deleteCase(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);


    @ApiOperation(value = "生成案件编号", notes = "生成唯一可用的案件编号", response = InlineResponse200.class, tags = {"case",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = InlineResponse200.class),
            @ApiResponse(code = 400, message = "操作失败", response = InlineResponse200.class)})
    @RequestMapping(value = "/case/generator",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<InlineResponse200> generatorCaseCode();


    @ApiOperation(value = "获取案件列表", notes = "获取案件列表（默认按<最后查看时间>倒序排列）", response = CaseInfo.class, responseContainer = "List", tags = {"case",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = CaseInfo.class),
            @ApiResponse(code = 400, message = "操作失败", response = CaseInfo.class)})
    @RequestMapping(value = "/case",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<CaseInfo>> selectCaseList();


    @ApiOperation(value = "编辑案件", notes = "编辑案件", response = Object.class, tags = {"case",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/case/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Object> updateCase(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                      @NotNull @ApiParam(value = "案件名称", required = true) @RequestParam(value = "caseName", required = true) String caseName,
                                      @NotNull @ApiParam(value = "负责人", required = true) @RequestParam(value = "caseOperator", required = true) String caseOperator,
                                      @NotNull @ApiParam(value = "立案日期", required = true) @RequestParam(value = "kickoffDate", required = true) String kickoffDate,
                                      @ApiParam(value = "备注") @RequestParam(value = "remark", required = false) String remark);

}
