package com.xaeport.cinsight.ui.api;


import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-17T09:45:03.910Z")
@RequestMapping(value = "/v10")
@Api(value = "search", description = "the search API")
public interface SearchApi {

    @ApiOperation(value = "检索", notes = "检索 邮件、附件、邮箱、联系人", response = Object.class, tags = {"search",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/search/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Object> getSearchDataCount(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                              @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions);

}
