package com.xaeport.cinsight.ui.api;


import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-20T03:31:23.696Z")
@RequestMapping(value = "/v10")
@Api(value = "contact", description = "the contact API")
public interface ContactApi {

    @ApiOperation(value = "获取联系人详情", notes = "获取联系人详情", response = Object.class, tags = {"contact",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/contact/{caseId}/{contactId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Object> getContactDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                            @ApiParam(value = "附件id", required = true) @PathVariable("contactId") String contactId);


    @ApiOperation(value = "联系人关系列表", notes = "联系人关系列表", response = Object.class, tags = {"contact",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/contact/{contactId}/relations",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Object> getContactRelationList(@ApiParam(value = "", required = true) @PathVariable("contactId") String contactId,
                                                  @NotNull @ApiParam(value = "", required = true) @RequestParam(value = "relationMail", required = true) String relationMail);


    @ApiOperation(value = "获取联系人列表", notes = "获取联系人列表", response = Object.class, tags = {"contact",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/contact/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Object> selectContactList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                             @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions);


    @ApiOperation(value = "联系人批注", notes = "联系人批注", response = Object.class, tags = {"contact",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/contact/{caseId}/{contactId}/notes",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Object> updateContactNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                              @ApiParam(value = "联系人id", required = true) @PathVariable("contactId") String contactId,
                                              @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes);


    @ApiOperation(value = "附件修改标签", notes = "附件修改标签", response = Object.class, tags = {"contact",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/contact/{caseId}/{contactId}/tag",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Object> updateContactTag(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                            @ApiParam(value = "联系人id", required = true) @PathVariable("contactId") String contactId,
                                            @NotNull @ApiParam(value = "附加的标签列表：array", required = true) @RequestParam(value = "tags", required = true) String tag);

}
