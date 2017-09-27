package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.entity.ResultSet;
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
@Api(value = "resultset", description = "the resultset API")
public interface ResultsetApi {

    @ApiOperation(value = "新增结果集", notes = "新增结果集", response = Object.class, tags={ "resultset", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/resultset/{caseId}",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Object> createResultSet(@ApiParam(value = "案件id",required=true ) @PathVariable("caseId") String caseId,
                                           @NotNull @ApiParam(value = "结果集名称", required = true) @RequestParam(value = "resultsetName", required = true) String resultsetName,
                                           @NotNull @ApiParam(value = "结果集token", required = true) @RequestParam(value = "resultsetToken", required = true) String resultsetToken,
                                           @NotNull @ApiParam(value = "检索条件", required = true) @RequestParam(value = "conditions", required = true) String conditions);


    @ApiOperation(value = "删除结果集", notes = "删除结果集", response = Object.class, tags={ "resultset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/resultset/{caseId}/{resultsetId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Object> deleteResultSet(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                           @ApiParam(value = "结果集id", required = true) @PathVariable("resultsetId") String resultsetId);


    @ApiOperation(value = "查询结果集详情", notes = "查询结果集详情", response = Object.class, tags={ "resultset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/resultset/{caseId}/{resultsetId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getResultSetDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                              @ApiParam(value = "结果集id", required = true) @PathVariable("resultsetId") String resultsetId);


    @ApiOperation(value = "查询结果集列表", notes = "查询结果集列表，按创建时间倒序排列 top100", response = ResultSet.class, responseContainer = "List", tags={ "resultset", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = ResultSet.class),
        @ApiResponse(code = 400, message = "操作失败", response = ResultSet.class) })
    @RequestMapping(value = "/resultset/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ResultSet>> selectResultSetList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);

}
