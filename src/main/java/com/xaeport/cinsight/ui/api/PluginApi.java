package com.xaeport.cinsight.ui.api;


import com.xaeport.cinsight.ui.data.entity.Lexicon;
import com.xaeport.cinsight.ui.data.entity.Plugin;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")
@RequestMapping(value = "/v10")
@Api(value = "plugin", description = "the plugin API")
public interface PluginApi {

    @ApiOperation(value = "获取词库配置列表", notes = "功能菜单获取词库配置列表", response = Lexicon.class, responseContainer = "List", tags={ "lexicon", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Lexicon.class),
        @ApiResponse(code = 400, message = "操作失败", response = Lexicon.class) })
    @RequestMapping(value = "/plugin/lexicon/options",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Lexicon>> selectLexiconOptionList();


    @ApiOperation(value = "获取插件列表", notes = "功能菜单获取插件列表", response = Plugin.class, responseContainer = "List", tags={ "plugin", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Plugin.class),
        @ApiResponse(code = 400, message = "操作失败", response = Plugin.class) })
    @RequestMapping(value = "/plugin/options",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Plugin>> selectPluginOptionList();


    @ApiOperation(value = "启用/禁用词库配置", notes = "功能菜单启用/禁用词库配置，lexiconIds为要启用的词库id集合，不再此数据中的id将被禁用", response = Object.class, tags={ "lexicon", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/plugin/lexicon/options",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Object> updateLexiconOptions(@NotNull @ApiParam(value = "插件id数组", required = true) @RequestParam(value = "lexiconIds", required = true) String lexiconIds);


    @ApiOperation(value = "启用/禁用插件", notes = "功能菜单启用/禁用插件，pluginIds为要启用的插件id集合，不再此数据中的id将被禁用", response = Object.class, tags={ "plugin", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/plugin/options",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Object> updatePluginOptions(@NotNull @ApiParam(value = "插件id数组", required = true) @RequestParam(value = "pluginIds", required = true) String pluginIds);

}
