package com.xaeport.cinsight.ui.controller;

import com.xaeport.cinsight.ui.api.PluginApi;
import com.xaeport.cinsight.ui.engine.model.ResponseData;
import com.xaeport.cinsight.ui.data.entity.Lexicon;
import com.xaeport.cinsight.ui.data.entity.Plugin;
import com.xaeport.cinsight.ui.service.LexiconService;
import com.xaeport.cinsight.ui.service.PluginService;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class PluginApiController implements PluginApi {

    @Autowired
    PluginService pluginService;
    @Autowired
    LexiconService lexiconService;

    private Log log = LogFactory.getLog(this.getClass());

    public ResponseEntity<List<Lexicon>> selectLexiconOptionList() {
        List<Lexicon> lexiconList = null;
        try {
            lexiconList = this.lexiconService.selectLexiconList();
        } catch (Exception e) {
            this.log.error("本地数据库查询词库列表失败", e);
            return new ResponseEntity<List<Lexicon>>(lexiconList, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Lexicon>>(lexiconList, HttpStatus.OK);
    }

    public ResponseEntity<List<Plugin>> selectPluginOptionList() {
        List<Plugin> pluginList = null;
        try {
            pluginList = this.pluginService.selectPluginList();
        } catch (Exception e) {
            this.log.error("本地数据库查询插件列表失败", e);
            return new ResponseEntity<List<Plugin>>(pluginList, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<List<Plugin>>(pluginList, HttpStatus.OK);

    }

    public ResponseEntity<Object> updateLexiconOptions(@NotNull @ApiParam(value = "插件id数组", required = true) @RequestParam(value = "lexiconIds", required = true) String lexiconIds) {
        String[] lexiconIdArray = lexiconIds.split(",");
        try {
            List<Lexicon> lexiconList = this.lexiconService.selectLexiconList();
            if (!CollectionUtils.isEmpty(lexiconList)) {
                for (int i = 0; i < lexiconList.size(); i++) {
                    lexiconList.get(i).setLexiconEnabled(false);
                    if (null != lexiconIdArray && lexiconIdArray.length > 0) {
                        for (int j = 0; j < lexiconIdArray.length; j++) {
                            if (lexiconList.get(i).getLexiconId().equals(lexiconIdArray[j])) {
                                lexiconList.get(i).setLexiconEnabled(true);
                            }
                        }
                    }
                }
                this.lexiconService.updateLexiconEnabled(lexiconList);
            }
        } catch (Exception e) {
            this.log.error("本地数据库查询插件列表失败", e);
            ResponseData responseData = new ResponseData();
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<Object> updatePluginOptions(@NotNull @ApiParam(value = "插件id数组", required = true) @RequestParam(value = "pluginIds", required = true) String pluginIds) {
        String[] pluginIdArray = pluginIds.split(",");
        try {
            List<Plugin> pluginList = this.pluginService.selectPluginList();
            if (!CollectionUtils.isEmpty(pluginList)) {
                for (int i = 0; i < pluginList.size(); i++) {
                    pluginList.get(i).setPluginEnabled(false);
                    if (null != pluginIdArray && pluginIdArray.length > 0) {
                        for (int j = 0; j < pluginIdArray.length; j++) {
                            if (pluginList.get(i).getPluginId().equals(pluginIdArray[j])) {
                                pluginList.get(i).setPluginEnabled(true);
                            }
                        }
                    }
                }
                this.pluginService.updatePluginEnabled(pluginList);
            }
        } catch (Exception e) {
            this.log.error("本地数据库查询插件列表失败", e);
            ResponseData responseData = new ResponseData();
            responseData.setMessage("本地数据库 操作异常");
            return new ResponseEntity<Object>(responseData, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
