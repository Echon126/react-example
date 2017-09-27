package com.xaeport.cinsight.ui.controller;


import com.alibaba.druid.support.json.JSONUtils;
import com.xaeport.cinsight.ui.api.AttachmentApi;
import com.xaeport.cinsight.ui.cache.Cache;
import com.xaeport.cinsight.ui.cache.CacheManager;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
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
public class AttachmentApiController implements AttachmentApi {
    private Map map = new HashMap();
    private Log log = LogFactory.getLog(this.getClass());
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private Conditions conditions;
    private com.xaeport.cinsight.ui.engine.api.AttachmentApi attachmentApi = new com.xaeport.cinsight.ui.engine.api.AttachmentApi();
    private com.xaeport.cinsight.ui.engine.api.MailApi mailApiClient = new com.xaeport.cinsight.ui.engine.api.MailApi();
    private com.xaeport.cinsight.ui.engine.api.NoteApi noteApiClient = new com.xaeport.cinsight.ui.engine.api.NoteApi();
    private com.xaeport.cinsight.ui.engine.api.TagApi tagApi = new com.xaeport.cinsight.ui.engine.api.TagApi();

    /**
     * 加载附件详情界面数据
     *
     * @param caseId
     * @param attachmentId
     * @return
     */
    public ResponseEntity<Object> getAttachmentDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                      @ApiParam(value = "附件id", required = true) @PathVariable("attachmentId") String attachmentId) {
        this.log.info("加载附件详情。。。。。。。。。");
        this.log.info("附件ID------------>" + attachmentId);
        Object attachmentDetail = null;
        if (!attachmentId.isEmpty()) {
            try {
                attachmentDetail = this.attachmentApi.getAttachmentDetail(attachmentId);
            } catch (ApiException e) {
                this.log.error("加载附近详情数据 API 调用失败", e);
                return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<Object>(attachmentDetail, HttpStatus.OK);
        } else {
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
    }

    /**
     * 加载附件相关性分析列表
     *
     * @param caseId
     * @param attachmentId
     * @return
     */
    public ResponseEntity<Object> getAttachmentRelation(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                        @ApiParam(value = "附件id", required = true) @PathVariable("attachmentId") String attachmentId) {
        this.log.info("加载附件相关性分析数据");
        this.log.info("附件id--------->" + attachmentId);
        Object attachmentRelation = null;
        String[] str = {attachmentId};
        String[] strname = {"attachmentId"};
        List conditionList = this.conditions.getList(str, strname);
        String conditions = JSONUtils.toJSONString(conditionList);
        try {
            attachmentRelation = this.mailApiClient.listMail(null);
        } catch (ApiException e) {
            this.log.error("加载邮件列表数据 api 调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(attachmentRelation, HttpStatus.OK);

    }

    /**
     * 加载附件列表数据
     *
     * @param caseId
     * @param conditions
     * @return
     */
    public ResponseEntity<Object> selectAttachmentList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                       @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions) {

        this.log.info("附件列表检索条件--------->" + conditions);
        Object attachmentList = null;
        String code = String.format("attachment%s%s", caseId, conditions);
        String cacheId = String.valueOf(code.hashCode());
        map.put("cacheId", cacheId);
        Cache cache = this.cacheManager.getCacheInfo(cacheId);
        boolean isExist = this.cacheManager.cacheExpired(cache);
        try {
            if (!isExist) {
                attachmentList = this.attachmentApi.listAttachment(null);
                cacheManager.putCacheInfo(cacheId, attachmentList, 100000, true);
            } else {
                attachmentList = cache.getValue();
            }
        } catch (ApiException e) {
            this.log.info("调用附件列表接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(attachmentList, HttpStatus.OK);

    }

    /**
     * 修改批注
     *
     * @param caseId
     * @param attachmentId
     * @param notes
     * @return
     */
    public ResponseEntity<Object> updateAttachmentNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                        @ApiParam(value = "附件id", required = true) @PathVariable("attachmentId") String attachmentId,
                                                        @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes) {

        this.log.info("案件id" + caseId);
        this.log.info("附件id" + attachmentId);
        this.log.info("批注内容" + notes);
        try {
            ResponseData responseData = (ResponseData) noteApiClient.updateNoteByObjectTypeAndId(2, attachmentId, notes);
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
     * @param attachmentId
     * @param tags
     * @return
     */
    public ResponseEntity<Object> updateAttachmentTag(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                      @ApiParam(value = "附件id", required = true) @PathVariable("attachmentId") String attachmentId,
                                                      @NotNull @ApiParam(value = "标签字符串 name1,name2,name3", required = true) @RequestParam(value = "tags", required = true) String tags,
                                                      @NotNull @ApiParam(value = "原始系统标签数目 sys_tag_count", required = true) @RequestParam(value = "sysTagCount", required = true) Integer sysTagCount) {

        this.log.info("案件ID " + caseId + "邮件ID " + attachmentId + "系统标签数" + sysTagCount);
        this.log.info("修改标签成功：tags=" + tags);
        try {
            ResponseData responseData = (ResponseData) tagApi.updateTagByObjectTypeAndId(2, attachmentId, tags, sysTagCount);
        } catch (ApiException e) {
            this.log.info("调用修改标签接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
