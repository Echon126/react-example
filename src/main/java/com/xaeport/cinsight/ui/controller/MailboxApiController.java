package com.xaeport.cinsight.ui.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import com.xaeport.cinsight.ui.api.MailboxApi;
import com.xaeport.cinsight.ui.cache.Cache;
import com.xaeport.cinsight.ui.cache.CacheManager;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.Mail;
import com.xaeport.cinsight.ui.engine.model.MailList;
import com.xaeport.cinsight.ui.engine.model.Mailbox;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
import com.xaeport.cinsight.ui.data.api.model.MailboxStatistics;
import com.xaeport.cinsight.ui.tools.Conditions;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class MailboxApiController implements MailboxApi {
    private Log log = LogFactory.getLog(this.getClass());
    private Gson gson = new Gson();
    private Map map = new HashMap();
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private Conditions conditions;

    private com.xaeport.cinsight.ui.engine.api.MailApi mailApiClient = new com.xaeport.cinsight.ui.engine.api.MailApi();
    private com.xaeport.cinsight.ui.engine.api.MailboxApi mailboxApiClient = new com.xaeport.cinsight.ui.engine.api.MailboxApi();
    private com.xaeport.cinsight.ui.engine.api.NoteApi noteApiClient = new com.xaeport.cinsight.ui.engine.api.NoteApi();
    private com.xaeport.cinsight.ui.engine.api.TagApi tagApi = new com.xaeport.cinsight.ui.engine.api.TagApi();

    public ResponseEntity<Object> getMailboxStatistics(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                       @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                       @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                       @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                       @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                       @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                       @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc) {
        MailboxStatistics mailboxStatistics = new MailboxStatistics();
        MailList mailInbox;
        MailList mailOutbox;
        MailList mailDraftbox;
        MailList mailTrashbox;
        if (!caseId.isEmpty() && !mailboxId.isEmpty()) {
            try {
                mailInbox = (MailList) mailApiClient.listMail("INBOX");
                int inboxCount = Math.toIntExact(mailInbox.getTotal());
                mailboxStatistics.setInboxCount(inboxCount);

                mailOutbox = (MailList) mailApiClient.listMail("OUTBOX");
                int outboxCount = Math.toIntExact(mailOutbox.getTotal());
                mailboxStatistics.setOutboxCount(outboxCount);

                mailDraftbox = (MailList) mailApiClient.listMail("DRAFTBOX");
                int draftboxCount = Math.toIntExact(mailDraftbox.getTotal());
                mailboxStatistics.setDraftboxCount(draftboxCount);

                mailTrashbox = (MailList) mailApiClient.listMail("TRASHBOX");
                int trashboxCount = Math.toIntExact(mailTrashbox.getTotal());
                mailboxStatistics.setTrashCount(trashboxCount);
            } catch (ApiException e) {
                e.printStackTrace();
            }
            return new ResponseEntity<Object>(mailboxStatistics, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
    }

    /**
     * 加载邮箱列表数据
     *
     * @param caseId
     * @param conditions
     * @return
     */
    public ResponseEntity<List<Mailbox>> selectMailboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                           @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions) {

        this.log.info("邮箱列表检索条件--------->" + conditions);

        List<Mailbox> mailboxList = null;
        String code = String.format("mailbox%s%s", caseId, conditions);
        String cacheId = String.valueOf(code.hashCode());
        Cache cache = this.cacheManager.getCacheInfo(cacheId);
        boolean isExist = this.cacheManager.cacheExpired(cache);
        try {
            if (!isExist) {
                mailboxList = this.mailboxApiClient.listMailBox(conditions);
                for (int i = 0; i < mailboxList.size(); i++) {
                    String attachmetId = mailboxList.get(i).getMailboxId();
                    map.put(attachmetId, i);
                }
            } else {
                mailboxList = (List<Mailbox>) cache.getValue();
            }
        } catch (ApiException e) {
            this.log.info("调用加载邮箱列表接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Mailbox>>(mailboxList, HttpStatus.OK);
    }

    /**
     * 根据筛选条件加载收件箱数据
     *
     * @param caseId
     * @param mailboxId
     * @param from
     * @param to
     * @param content
     * @param subject
     * @param cc
     * @return
     */
    public ResponseEntity<List<Mail>> selecInboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                     @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                     @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                     @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                     @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                     @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                     @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc) {
        this.log.info("发件人" + from + "收件人" + to + "内容关键词" + content + "主题内容关键词" + subject + "抄送人" + cc);
        List<Mail> mail = null;
        String inbox = "INBOX";
        String[] str = {mailboxId, from, to, content, subject, cc, inbox};
        String[] strname = {"mailboxId", "from", "to", "content", "subject", "cc", "INBOX"};
        List conditionList = this.conditions.getList(str, strname);
        String conditions = JSONUtils.toJSONString(conditionList);

        com.xaeport.cinsight.ui.engine.model.MailList maillist;
        Mail mailDetail;
        try {
            maillist = (MailList) mailApiClient.listMail(conditions);
            mail = maillist.getMails();
        } catch (ApiException e) {
            this.log.error("加载邮件列表数据 api 调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Mail>>(mail, HttpStatus.OK);

    }

    /**
     * 根据筛选条件加载发件箱数据
     *
     * @param caseId
     * @param mailboxId
     * @param from
     * @param to
     * @param content
     * @param subject
     * @param cc
     * @return
     */
    public ResponseEntity<List<Mail>> selecOutboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                      @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                      @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                      @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                      @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                      @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                      @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc) {
        this.log.info("发件人" + from + "收件人" + to + "内容关键词" + content + "主题内容关键词" + subject + "抄送人" + cc);
        List<Mail> mail = null;
        String outbox = "OUTBOX";
        String[] str = {mailboxId, from, to, content, subject, cc, outbox};
        String[] strname = {"mailboxId", "from", "to", "content", "subject", "cc", "OUTBOX"};
        List conditionList = this.conditions.getList(str, strname);
        String conditions = JSONUtils.toJSONString(conditionList);
        com.xaeport.cinsight.ui.engine.model.MailList maillist;
        Mail mailDetail;
        try {
            maillist = (MailList) mailApiClient.listMail(conditions);
            mail = maillist.getMails();
        } catch (ApiException e) {
            this.log.error("加载邮件列表数据 api 调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Mail>>(mail, HttpStatus.OK);

    }

    /**
     * 根据筛选条件加载草稿箱数据
     *
     * @param caseId
     * @param mailboxId
     * @param from
     * @param to
     * @param content
     * @param subject
     * @param cc
     * @return
     */
    public ResponseEntity<List<Mail>> selecDraftboxList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                        @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                        @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                        @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                        @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                        @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                        @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc) {


        this.log.info("发件人" + from + "收件人" + to + "内容关键词" + content + "主题内容关键词" + subject + "抄送人" + cc);
        List<Mail> mail = null;
        String draftbox = "DRAFTBOX";
        String[] str = {mailboxId, from, to, content, subject, cc, draftbox};
        String[] strname = {"mailboxId", "from", "to", "content", "subject", "cc", "DRAFTBOX"};
        List conditionList = this.conditions.getList(str, strname);
        String conditions = JSONUtils.toJSONString(conditionList);
        com.xaeport.cinsight.ui.engine.model.MailList maillist;
        Mail mailDetail;
        try {
            maillist = (MailList) mailApiClient.listMail(conditions);
            mail = maillist.getMails();
        } catch (ApiException e) {
            this.log.error("加载邮件列表数据 api 调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Mail>>(mail, HttpStatus.OK);

    }

    /**
     * 根据筛选条件加载垃圾箱数据
     *
     * @param caseId
     * @param mailboxId
     * @param from
     * @param to
     * @param content
     * @param subject
     * @param cc
     * @return
     */
    public ResponseEntity<List<Mail>> selecTrashList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                     @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                     @ApiParam(value = "发件人") @RequestParam(value = "from", required = false) String from,
                                                     @ApiParam(value = "收件人") @RequestParam(value = "to", required = false) String to,
                                                     @ApiParam(value = "内容关键词") @RequestParam(value = "content", required = false) String content,
                                                     @ApiParam(value = "主题内容关键词") @RequestParam(value = "subject", required = false) String subject,
                                                     @ApiParam(value = "抄送人") @RequestParam(value = "cc", required = false) String cc) {
        this.log.info("发件人" + from + "收件人" + to + "内容关键词" + content + "主题内容关键词" + subject + "抄送人" + cc);
        List<Mail> mail = null;
        String trashbox = "TRASHBOX";
        String[] str = {mailboxId, from, to, content, subject, cc, trashbox};
        String[] strname = {"mailboxId", "from", "to", "content", "subject", "cc", "TRASHBOX"};
        List conditionList = this.conditions.getList(str, strname);
        String conditions = JSONUtils.toJSONString(conditionList);
        com.xaeport.cinsight.ui.engine.model.MailList maillist;
        Mail mailDetail;
        try {
            maillist = (MailList) mailApiClient.listMail(conditions);
            mail = maillist.getMails();
        } catch (ApiException e) {
            this.log.error("加载邮件列表数据 api 调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Mail>>(mail, HttpStatus.OK);

    }

    /**
     * 修改批注
     *
     * @param caseId
     * @param mailboxId
     * @param notes
     * @return
     */

    public ResponseEntity<Object> updateMailboxNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                     @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                     @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes) {
        this.log.info("案件id" + caseId);
        this.log.info("附件id" + mailboxId);
        this.log.info("批注内容" + notes);

        try {
            ResponseData responseData = (ResponseData) noteApiClient.updateNoteByObjectTypeAndId(0, mailboxId, notes);
        } catch (ApiException e) {
            this.log.info("修改批注 Api 调用失败", e);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    /**
     * 修改标签
     *
     * @param caseId
     * @param mailboxId
     * @param tags
     * @return
     */
    public ResponseEntity<Object> updateMailboxTag(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                   @ApiParam(value = "邮箱id", required = true) @PathVariable("mailboxId") String mailboxId,
                                                   @NotNull @ApiParam(value = "附加的标签列表：array", required = true) @RequestParam(value = "tags", required = true) List<String> tags) {
        this.log.info("案件ID " + caseId + "邮箱ID " + mailboxId);
        this.log.info("修改标签成功：tags=" + tags);
        /*try {
            ResponseData responseData = (ResponseData) tagApi.updateTagByObjectTypeAndId(0, mailboxId, tags);
        } catch (ApiException e) {
            this.log.info("调用修改标签接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }*/
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
