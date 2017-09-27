package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.entity.History;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")
@RequestMapping(value = "/v10")
@Api(value = "history", description = "the history API")
public interface HistoryApi {

    @ApiOperation(value = "新增操作记录", notes = "新增操作记录", response = Object.class, tags={ "history", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/history/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Object> createHistory(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                         @NotNull @ApiParam(value = "操作记录名称", required = true) @RequestParam(value = "historyName", required = true) String historyName,
                                         @NotNull @ApiParam(value = "操作界面", required = true) @RequestParam(value = "historyPage", required = true) String historyPage,
                                         @NotNull @ApiParam(value = "详情id", required = true) @RequestParam(value = "detailId", required = true) String detailId,
                                         @NotNull @ApiParam(value = "检索条件", required = true) @RequestParam(value = "conditions", required = true) String conditions);


    @ApiOperation(value = "删除操作记录", notes = "删除操作记录", response = Object.class, tags={ "resultset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/history/{caseId}/{historyId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Object> deleteHistory(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                         @ApiParam(value = "操作记录id", required = true) @PathVariable("historyId") String historyId);


    @ApiOperation(value = "查询操作记录详情", notes = "查询操作记录详情", response = Object.class, tags={ "history", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/history/{caseId}/{historyId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getHistoryDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                            @ApiParam(value = "操作记录id", required = true) @PathVariable("historyId") String historyId);


    @ApiOperation(value = "查询操作记录列表", notes = "查询操作记录列表，按创建时间倒序排列 top100", response = History.class, responseContainer = "List", tags={ "history", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = History.class),
        @ApiResponse(code = 400, message = "操作失败", response = History.class) })
    @RequestMapping(value = "/history/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<History>> selectHistoryList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);

}
