package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.api.model.AttachmentList;
import com.xaeport.cinsight.ui.data.api.model.MailList;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")
@RequestMapping(value = "/v10")
@Api(value = "attachment", description = "the attachment API")
public interface AttachmentApi {

    @ApiOperation(value = "获取附件详情", notes = "获取附件详情", response = Object.class, tags={ "attachment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/attachment/{caseId}/{attachmentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getAttachmentDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                               @ApiParam(value = "附件id", required = true) @PathVariable("attachmentId") String attachmentId);


    @ApiOperation(value = "相关性分析", notes = "附件相关性分析,按照发送时间倒序排列", response = MailList.class, responseContainer = "List", tags={ "attachment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = MailList.class),
        @ApiResponse(code = 400, message = "操作失败", response = MailList.class) })
    @RequestMapping(value = "/attachment/{caseId}/{attachmentId}/mail",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getAttachmentRelation(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                         @ApiParam(value = "附件id", required = true) @PathVariable("attachmentId") String attachmentId);


    @ApiOperation(value = "获取附件列表", notes = "获取附件列表", response = AttachmentList.class, responseContainer = "List", tags={ "attachment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = AttachmentList.class),
        @ApiResponse(code = 400, message = "操作失败", response = AttachmentList.class) })
    @RequestMapping(value = "/attachment/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> selectAttachmentList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                          @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions);


    @ApiOperation(value = "附件批注", notes = "附件批注", response = Object.class, tags={ "attachment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/attachment/{caseId}/{attachmentId}/notes",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Object> updateAttachmentNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                 @ApiParam(value = "附件id", required = true) @PathVariable("attachmentId") String attachmentId,
                                                 @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes);


    @ApiOperation(value = "附件修改标签", notes = "附件修改标签", response = Object.class, tags={ "attachment", })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/attachment/{caseId}/{attachmentId}/tag",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Object> updateAttachmentTag(@ApiParam(value = "案件id",required=true ) @PathVariable("caseId") String caseId,
                                               @ApiParam(value = "附件id",required=true ) @PathVariable("attachmentId") String attachmentId,
                                               @NotNull @ApiParam(value = "标签字符串 name1,name2,name3", required = true) @RequestParam(value = "tags", required = true) String tags,
                                               @NotNull @ApiParam(value = "原始系统标签数目 sys_tag_count", required = true) @RequestParam(value = "sysTagCount", required = true) Integer sysTagCount);
}
