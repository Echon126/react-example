package com.xaeport.cinsight.ui.controller;

import com.xaeport.cinsight.ui.api.TagApi;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.Tag;
import com.xaeport.cinsight.ui.data.api.model.Correct;
import com.xaeport.cinsight.ui.data.api.model.TagChild;
import com.xaeport.cinsight.ui.data.api.model.TagTree;
import com.xaeport.cinsight.ui.data.entity.CustomTag;
import com.xaeport.cinsight.ui.service.CustomTagService;
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
import java.util.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class TagApiController implements TagApi {

    @Autowired
    CustomTagService customTagService;

    private Log log = LogFactory.getLog(this.getClass());
    private com.xaeport.cinsight.ui.engine.api.TagApi tagApi = new com.xaeport.cinsight.ui.engine.api.TagApi();

    public ResponseEntity<List<TagTree>> selectTagList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        List<Tag> taglist = null;
        try {
            taglist = this.tagApi.listTag();
        } catch (ApiException e) {
            this.log.error("调用标签数接口 API 失败", e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        Map<String, List<Tag>> map = this.getTagData(taglist);
        List<com.xaeport.cinsight.ui.data.api.model.TagTree> tagList = new ArrayList<>();
        com.xaeport.cinsight.ui.data.api.model.TagTree tag = null;
        for (Map.Entry<String, List<Tag>> entry : map.entrySet()) {
            tag = new com.xaeport.cinsight.ui.data.api.model.TagTree();
            String type = entry.getKey();
            tag.setTypeName(type);
            tag.setTypeIcon("fa fa-edit");
            List<Tag> list = entry.getValue();
            List<TagChild> childList = new ArrayList<>();
            TagChild tagChild = null;
            for (int i = 0; i < list.size(); i++) {
                tagChild = new TagChild();
                tagChild.setTagName(list.get(i).getTagName());
                tagChild.setHitCount(Math.toIntExact(list.get(i).getHitNumber()));
                childList.add(tagChild);
                tag.setTags(childList);
            }
            tagList.add(tag);
        }
        return new ResponseEntity<List<TagTree>>(tagList, HttpStatus.OK);
    }


    public ResponseEntity<List<CustomTag>> selectCustomTagList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        List<CustomTag> customTagList = null;
        try {
            customTagList = customTagService.selectCustomTagList();
        } catch (Exception e) {
            this.log.error("本地数据库查询自定义标签列表失败", e);
            return new ResponseEntity<List<CustomTag>>(customTagList, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<CustomTag>>(customTagList, HttpStatus.OK);
    }

    public ResponseEntity<Object> createCustomTagList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                      @NotNull @ApiParam(value = "自定义标签name", required = true) @RequestParam(value = "tagName", required = true) String tagName) {
        boolean isError = false;
        Correct correct = new Correct();
        int tagNameIsExist = this.customTagService.checkTagNameCount(tagName);

        // tagname 已存在
        if (tagNameIsExist > 0) {
            correct.setMessage("自定义标签名称重复");
            return new ResponseEntity(correct, HttpStatus.BAD_REQUEST);
        }

        CustomTag customTag = new CustomTag();
        String tagId = UUID.randomUUID().toString();
        customTag.setTagId(tagId);
        customTag.setTagName(tagName);
        customTag.setTagIcon("fa fa-coffee");
        customTag.setFrequency(1);
        customTag.setCreateTime(System.currentTimeMillis());
        customTag.setLastUseTime(System.currentTimeMillis());
        try {
            this.customTagService.createCustomTag(customTag);
        } catch (Exception e) {
            isError = true;
            this.log.error("createCase 本地数据库操作失败", e);
            correct.setMessage("本地数据库 操作异常");
        }
        if (isError) {
            return new ResponseEntity(correct, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(HttpStatus.OK);
        }
    }

    private Map<String, List<Tag>> getTagData(List<Tag> tags) {
        List<TagTree> tagList = null;
        Map<String, List<Tag>> map = new LinkedHashMap<String, List<Tag>>();
        for (int i = 0; i < tags.size(); i++) {
            String type = tags.get(i).getTagCategory();
            String name = tags.get(i).getTagName();
            int amount = tags.get(i).getHitNumber();

            TagChild tagChild = new TagChild();
            tagChild.setTagName(name);
            tagChild.setHitCount(Math.toIntExact(amount));

            if (map.containsKey(type)) {
                map.get(type).add(tags.get(i));
            } else {
                List<Tag> list = new ArrayList<>();
                list.add(tags.get(i));
                map.put(type, list);
            }
        }
        return map;
    }
}
