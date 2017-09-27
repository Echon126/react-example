package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.api.model.Load;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")
@RequestMapping(value = "/v10")
@Api(value = "load", description = "the load API")
public interface LoadApi {

    @ApiOperation(value = "查询装载报告", notes = "装载完成程中，查看装载报告", response = Object.class, tags={ "load", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/load/{caseId}/report",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getLoadReport(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);


    @ApiOperation(value = "查询装载状态", notes = "装载过程中，实时查看装载状态", response = Object.class, tags={ "load", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/load/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getLoadState(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);


    @ApiOperation(value = "开始装载", notes = "点击开始装载按钮，装载邮件数据", response = Object.class, tags={ "load", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/load/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Object> loadMailData(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                        @NotNull @ApiParam(value = "插件名称", required = true) @RequestParam(value = "source", required = true) List<String> source,
                                        @NotNull @ApiParam(value = "配置项集合", required = true) @RequestParam(value = "options", required = true) List<String> options);


    @ApiOperation(value = "数据装载插件配置列表", notes = "数据装载时查询数据装载插件配置列表", response = Load.class, responseContainer = "List", tags={ "load", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Load.class),
        @ApiResponse(code = 400, message = "操作失败", response = Load.class) })
    @RequestMapping(value = "/load/{caseId}/options",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Load>> selectLoadCaseOptionList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);


    @ApiOperation(value = "停止装载", notes = "停止装载", response = Object.class, tags={ "load", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/load/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Object> stopLoadMail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);

}
