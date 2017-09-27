package com.xaeport.cinsight.ui.controller;


import com.xaeport.cinsight.ui.configuration.AppConfiguration;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Created by xcp on 2017/3/27.
 */
@Controller
@ApiIgnore //忽略显示api
public class JumpController extends BaseController {

    private Log log = LogFactory.getLog(this.getClass());
    private File templatesFolder;

    @PostConstruct
    private void init() {
        this.templatesFolder = new File(AppConfiguration.getBaseFolder(), "templates");
    }

    @ApiOperation(value = "访问主页", notes = "输入/进入主页描述")
    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @ApiOperation(value = "访问主页", notes = "输入/进入主页描述")
    @RequestMapping(value = {"/page"}, method = RequestMethod.GET)
    public String page(@RequestParam(value = "p") String pageName, Model model, HttpServletRequest request) throws FileNotFoundException {
        if (!this.verifyTemplate(pageName, this.templatesFolder, log)) {
            this.log.error("找不到请求的模版文件：" + pageName);
            throw new FileNotFoundException();
        }
//        model.addAttribute("user", user);
//        model.addAttribute("ip", ip);
//        model.addAttribute("port", port);
//        model.addAttribute("protocol", protocol);
        return pageName;
    }


}
