package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.api.model.MailList;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")
@RequestMapping(value = "/v10")
@Api(value = "mail", description = "the mail API")
public interface MailApi {

    @ApiOperation(value = "获取邮件详情", notes = "获取邮件详情", response = Object.class, tags = {"mail",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/mail/{caseId}/{mailId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Object> getMailDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                         @ApiParam(value = "邮件id", required = true) @PathVariable("mailId") String mailId);


    @ApiOperation(value = "获取邮件列表", notes = "获取邮件列表，按照发送时间倒序排列", response = MailList.class, responseContainer = "List", tags = {"mail",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = MailList.class),
            @ApiResponse(code = 400, message = "操作失败", response = MailList.class)})
    @RequestMapping(value = "/mail/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<Object> selectMailList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                          @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions);


    @ApiOperation(value = "邮件批注", notes = "邮件批注", response = Object.class, tags = {"mail",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/mail/{caseId}/{mailId}/notes",
            produces = {"application/json"},
            method = RequestMethod.PUT)
    ResponseEntity<Object> updateMailNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                           @ApiParam(value = "邮件id", required = true) @PathVariable("mailId") String mailId,
                                           @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes);


    @ApiOperation(value = "邮件修改标签", notes = "邮件修改标签", response = Object.class, tags={ "mail", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/mail/{caseId}/{mailId}/tag",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Object> updateMailTag(@ApiParam(value = "案件id",required=true ) @PathVariable("caseId") String caseId,
                                         @ApiParam(value = "邮件id",required=true ) @PathVariable("mailId") String mailId,
                                         @NotNull @ApiParam(value = "标签字符串 name1,name2,name3", required = true) @RequestParam(value = "tags", required = true) String tags,
                                         @NotNull @ApiParam(value = "原始系统标签数目 sys_tag_count", required = true) @RequestParam(value = "sysTagCount", required = true) Integer sysTagCount);


}
