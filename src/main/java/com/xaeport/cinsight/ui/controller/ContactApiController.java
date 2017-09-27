package com.xaeport.cinsight.ui.controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.xaeport.cinsight.ui.api.ContactApi;
import com.xaeport.cinsight.ui.cache.Cache;
import com.xaeport.cinsight.ui.cache.CacheManager;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.ContactDetail;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-06-20T03:31:23.696Z")

@Controller
public class ContactApiController implements ContactApi {
    private Log log = LogFactory.getLog(this.getClass());
    private Map map = new HashMap();
    @Autowired
    private CacheManager cacheManager;

    private com.xaeport.cinsight.ui.engine.api.MailApi mailApiClient = new com.xaeport.cinsight.ui.engine.api.MailApi();
    private com.xaeport.cinsight.ui.engine.api.ContactApi contactApi = new com.xaeport.cinsight.ui.engine.api.ContactApi();
    private com.xaeport.cinsight.ui.engine.api.NoteApi noteApiClient = new com.xaeport.cinsight.ui.engine.api.NoteApi();
    private com.xaeport.cinsight.ui.engine.api.TagApi tagApi = new com.xaeport.cinsight.ui.engine.api.TagApi();

    /**
     * 获取联系人详情
     *
     * @param caseId
     * @param contactId
     * @return
     */
    public ResponseEntity<Object> getContactDetail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                   @ApiParam(value = "附件id", required = true) @PathVariable("contactId") String contactId) {
        this.log.info("加载联系人详情。。。。。。");
        this.log.info("联系人ID------------------->" + contactId);
        ContactDetail contactDetail = null;
        try {
            contactDetail = (ContactDetail) this.contactApi.getContactById(contactId);
        } catch (ApiException e) {
            this.log.error("加载联系人图表数据 API 接口调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(contactDetail, HttpStatus.OK);
    }

    public ResponseEntity<Object> getContactRelationList(@ApiParam(value = "", required = true) @PathVariable("contactId") String contactId,

                                                         @NotNull @ApiParam(value = "", required = true) @RequestParam(value = "relationMail", required = true) String relationMail) {
        Object relationList = null;
        try {
            relationList = this.contactApi.getContactRelationList(contactId, relationMail);
        } catch (ApiException e) {
            this.log.error("加载相关联联系人接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(relationList, HttpStatus.OK);
    }

    public ResponseEntity<Object> selectContactList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                    @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions) {
        this.log.info("联系人检索条件--------->" + conditions);
        Object contactList = null;
        String code = String.format("contact%s%s", caseId, conditions);
        String cacheId = String.valueOf(code.hashCode());
        map.put("cacheId", cacheId);
        Cache cache = this.cacheManager.getCacheInfo(cacheId);
        boolean isExist = this.cacheManager.cacheExpired(cache);
        try {
            if (!isExist) {
                contactList = this.contactApi.listContact(null);
                this.cacheManager.putCacheInfo(cacheId, contactList, 100000, true);
            } else {
                contactList = cache.getValue();
            }
        } catch (ApiException e) {
            this.log.error("加载联系人图表数据 API 接口调用失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(contactList, HttpStatus.OK);
    }

    public ResponseEntity<Object> updateContactNotes(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                     @ApiParam(value = "联系人id", required = true) @PathVariable("contactId") String contactId,
                                                     @NotNull @ApiParam(value = "批注内容", required = true) @RequestParam(value = "notes", required = true) String notes) {
        this.log.info("案件id" + caseId);
        this.log.info("附件id" + contactId);
        this.log.info("批注内容" + notes);
        try {
            ResponseData responseData = (ResponseData) noteApiClient.updateNoteByObjectTypeAndId(0, contactId, notes);
        } catch (ApiException e) {
            this.log.error("修改批注 Api 调用失败", e);
            return new ResponseEntity<Object>(HttpStatus.OK);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> updateContactTag(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                   @ApiParam(value = "联系人id", required = true) @PathVariable("contactId") String contactId,
                                                   @NotNull @ApiParam(value = "附加的标签列表：array", required = true) @RequestParam(value = "tags", required = true) String tag) {
        this.log.info("案件ID " + caseId + "联系人ID " + contactId);
        try {
            ResponseData responseData = (ResponseData) tagApi.updateTagByObjectTypeAndId(3, contactId, tag, 1);
        } catch (ApiException e) {
            this.log.error("调用修改标签接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
