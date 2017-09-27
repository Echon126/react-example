package com.xaeport.cinsight.ui.api;

import com.xaeport.cinsight.ui.engine.model.Mail;
import com.xaeport.cinsight.ui.data.api.model.Mailbox;
import com.xaeport.cinsight.ui.data.api.model.MailboxList;
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
@Api(value = "mailbox", description = "the mailbox API")
public interface MailboxApi {

    @ApiOperation(value = "获取邮箱统计", notes = "获取邮箱统计", response = Object.class, tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/mailbox/{caseId}/{mailboxId}/filter",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Object> getMailboxStatistics(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc);


    @ApiOperation(value = "获取所选邮箱中的草稿箱邮件列表", notes = "获取所选邮箱中的草稿箱邮件列表", response = Mailbox.class, responseContainer = "List", tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Mailbox.class),
        @ApiResponse(code = 400, message = "操作失败", response = Mailbox.class) })
    @RequestMapping(value = "/mailbox/{caseId}/{mailboxId}/draftbox",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Mail>> selecDraftboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                    @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                    @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                    @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                    @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                    @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                    @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc);


    @ApiOperation(value = "获取所选邮箱中的收件箱邮件列表", notes = "获取所选邮箱中的收件箱邮件列表", response = Mailbox.class, responseContainer = "List", tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Mailbox.class),
        @ApiResponse(code = 400, message = "操作失败", response = Mailbox.class) })
    @RequestMapping(value = "/mailbox/{caseId}/{mailboxId}/inbox",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Mail>> selecInboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                 @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                 @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                 @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                 @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                 @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                 @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc);


    @ApiOperation(value = "获取所选邮箱中的发件箱邮件列表", notes = "获取所选邮箱中的发件箱邮件列表", response = Mailbox.class, responseContainer = "List", tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Mailbox.class),
        @ApiResponse(code = 400, message = "操作失败", response = Mailbox.class) })
    @RequestMapping(value = "/mailbox/{caseId}/{mailboxId}/outbox",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Mail>> selecOutboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                  @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                  @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                  @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                  @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                  @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                  @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc);


    @ApiOperation(value = "获取所选邮箱中的垃圾箱邮件列表", notes = "获取所选邮箱中的垃圾箱邮件列表", response = Mailbox.class, responseContainer = "List", tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Mailbox.class),
        @ApiResponse(code = 400, message = "操作失败", response = Mailbox.class) })
    @RequestMapping(value = "/mailbox/{caseId}/{mailboxId}/trash",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Mail>> selecTrashList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                 @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                 @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                 @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                 @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                 @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                 @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc);


    @ApiOperation(value = "获取邮箱列表", notes = "获取邮箱列表", response = MailboxList.class, responseContainer = "List", tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = MailboxList.class),
        @ApiResponse(code = 400, message = "操作失败", response = MailboxList.class) })
    @RequestMapping(value = "/mailbox/{caseId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<com.xaeport.cinsight.ui.engine.model.Mailbox>> selectMailboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                                                         @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions);


    @ApiOperation(value = "邮箱批注", notes = "邮箱批注", response = Object.class, tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/mailbox/{caseId}/{mailboxId}/notes",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Object> updateMailboxNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                              @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                              @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes);


    @ApiOperation(value = "邮箱修改标签", notes = "邮箱修改标签", response = Object.class, tags={ "mailbox", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/mailbox/{caseId}/{mailboxId}/tag",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Object> updateMailboxTag(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                            @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                            @NotNull @ApiParam(value = "附加的标签列表：array", required = true) @RequestParam(value = "tags", required = true) List<String>  tags);

}
