package com.xaeport.cinsight.ui.controller;


import com.xaeport.cinsight.ui.api.MailApi;
import com.xaeport.cinsight.ui.cache.Cache;
import com.xaeport.cinsight.ui.cache.CacheManager;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
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
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class MailApiController implements MailApi {
    private Log log = LogFactory.getLog(this.getClass());
    private Map map = new HashMap();
    @Autowired
    private CacheManager cacheManager;
    //实例化API接口
    private com.xaeport.cinsight.ui.engine.api.MailApi mailApiClient = new com.xaeport.cinsight.ui.engine.api.MailApi();
    private com.xaeport.cinsight.ui.engine.api.NoteApi noteApiClient = new com.xaeport.cinsight.ui.engine.api.NoteApi();
    private com.xaeport.cinsight.ui.engine.api.TagApi tagApi = new com.xaeport.cinsight.ui.engine.api.TagApi();
    private com.xaeport.cinsight.ui.engine.api.AttachmentApi attachmentApi = new com.xaeport.cinsight.ui.engine.api.AttachmentApi();


    /**
     * 加载邮件详情
     *
     * @param caseId
     * @param mailId
     * @return
     */
    public ResponseEntity<Object> getMailDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                @ApiParam(value = "邮件id", required = true) @PathVariable("mailId") String mailId) {
        this.log.info("加载邮件详情。。。。。");
        this.log.info("邮件ID" + mailId);
        Object mailDetail = null;
        if (!mailId.isEmpty()) {
            try {
                mailDetail = this.mailApiClient.getMailDetail(mailId);
            } catch (ApiException e) {
                this.log.error("加载邮件详情数据 API 失败", e);
                return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Object>(mailDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
    }


    /**
     * 加载邮件列表
     *
     * @param caseId
     * @param conditions
     * @return
     */
    public ResponseEntity<Object> selectMailList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                 @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions) {
        this.log.info("邮件列表检索条件--------->" + conditions);
        Object listMail = null;
        String code = String.format("mail%s%s", caseId, conditions);
        String cacheId = String.valueOf(code.hashCode());
        map.put("cacheId", cacheId);
        Cache cache = this.cacheManager.getCacheInfo(cacheId);
        boolean isExist = this.cacheManager.cacheExpired(cache);
        try {
            if (!isExist) {
                listMail = this.mailApiClient.listMail(null);
                this.cacheManager.putCacheInfo(cacheId, listMail, 100000, true);
            } else {
                listMail = cache.getValue();
            }
        } catch (ApiException e) {
            this.log.error("加载邮件列表数据 api 调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(listMail, HttpStatus.OK);
    }

    /**
     * 修改批注
     *
     * @param caseId
     * @param mailId
     * @param notes
     * @return
     */
    public ResponseEntity<Object> updateMailNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                  @ApiParam(value = "邮件id", required = true) @PathVariable("mailId") String mailId,
                                                  @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes) {
        this.log.info("案件id" + caseId);
        this.log.info("附件id" + mailId);
        this.log.info("批注内容" + notes);
        try {
            ResponseData responseData = (ResponseData) noteApiClient.updateNoteByObjectTypeAndId(1, mailId, notes);
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
     * @param mailId
     * @param tags
     * @return
     */
    public ResponseEntity<Object> updateMailTag(@ApiParam(value = "案件id",required=true ) @PathVariable("caseId") String caseId,
                                                @ApiParam(value = "邮件id",required=true ) @PathVariable("mailId") String mailId,
                                                @NotNull @ApiParam(value = "标签字符串 name1,name2,name3", required = true) @RequestParam(value = "tags", required = true) String tags,
                                                @NotNull @ApiParam(value = "原始系统标签数目 sys_tag_count", required = true) @RequestParam(value = "sysTagCount", required = true) Integer sysTagCount) {
        this.log.info("案件ID " + caseId + "邮件ID " + mailId);
        try {
            ResponseData responseData = (ResponseData) tagApi.updateTagByObjectTypeAndId(1, mailId, tags,sysTagCount);
        } catch (ApiException e) {
            this.log.info("调用修改标签接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
