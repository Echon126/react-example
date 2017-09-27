package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.api.model.TagTree;
import com.xaeport.cinsight.ui.data.entity.CustomTag;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")
@RequestMapping(value = "/v10")
@Api(value = "tag", description = "the tag API")
public interface TagApi {

    @ApiOperation(value = "新建自定义标签", notes = "新建自定义标签", response = Object.class, tags = {"tag",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = Object.class),
            @ApiResponse(code = 400, message = "操作失败", response = Object.class)})
    @RequestMapping(value = "/tag/customs/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.POST)
    ResponseEntity<Object> createCustomTagList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                               @NotNull @ApiParam(value = "自定义标签name", required = true) @RequestParam(value = "tagName", required = true) String tagName);


    @ApiOperation(value = "查询标签列表", notes = "查询标签树列表，按标签类型排序", response = Tag.class, responseContainer = "List", tags = {"tag",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = TagTree.class),
            @ApiResponse(code = 400, message = "操作失败", response = TagTree.class)})
    @RequestMapping(value = "/tag/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<TagTree>> selectTagList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);


    @ApiOperation(value = "查询自定义标签列表", notes = "查询自定义标签列表，按标签类型排序", response = CustomTag.class, responseContainer = "List", tags = {"tag",})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "操作成功", response = CustomTag.class),
            @ApiResponse(code = 400, message = "操作失败", response = CustomTag.class)})
    @RequestMapping(value = "/tag/customs/{caseId}",
            produces = {"application/json"},
            method = RequestMethod.GET)
    ResponseEntity<List<CustomTag>> selectCustomTagList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId);
}
