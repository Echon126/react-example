package com.xaeport.cinsight.ui.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * controller Base 父类
 * Created by xcp on 2016/11/30.
 */
public class BaseController {
    private Log log = LogFactory.getLog(this.getClass());
    protected final String key = "%@!!#!$";
    protected final String defaultPassword = "123456";

    //校验模版是否存在
    protected boolean verifyTemplate(String templateName, File templatesFolder, Log log) {

        if (templateName.contains("..")) {
            log.warn("疑似非法的模版文件请求：" + templateName);
            return false;
        }
        templateName += ".html";
        File templateFile = new File(templatesFolder, templateName);
        return templateFile.exists();
    }


    @RequestMapping(value = "showImg")
    public void showImg(HttpServletRequest request, HttpServletResponse response) {
        String uri = request.getParameter("uri"); //文件名
        System.out.println(uri);
        FileInputStream fileIs;
        OutputStream outStream = null;
        //后端校验
        String reg = ".+(.jpeg|.jpg|.gif|.bmp|.png)$";
        Pattern pattern = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(uri);
        if (matcher.find()) {
            try {
                fileIs = new FileInputStream(uri);
            } catch (Exception e) {
                this.log.error("系统找不到图像文件：" + uri);
                return;
            }
            try {
                int i = fileIs.available(); //得到文件大小
                byte data[] = new byte[i];
                fileIs.read(data);  //读数据
                response.setContentType("image/*"); //设置返回的文件类型
                outStream = response.getOutputStream(); //得到向客户端输出二进制数据的对象
                outStream.write(data);  //输出数据
                outStream.flush();
            } catch (IOException io) {
                this.log.error("图像文件流读写异常：" + uri, io);
            } finally {
                try {
                    if (outStream != null) {
                        outStream.close();
                    }
                    if (fileIs != null) {
                        fileIs.close();
                    }
                } catch (IOException i) {
                    this.log.error("图像文件流关闭异常：" + uri, i);
                }
            }
        }
    }
}
