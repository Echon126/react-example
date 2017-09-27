package com.xaeport.cinsight.ui.controller;

import com.xaeport.cinsight.ui.api.LoadApi;
import com.xaeport.cinsight.ui.data.api.model.Load;
import com.xaeport.cinsight.ui.data.api.model.LoadReport;
import com.xaeport.cinsight.ui.data.api.model.LoadState;
import com.xaeport.cinsight.ui.data.api.model.Option;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class LoadApiController implements LoadApi {

    private Log log = LogFactory.getLog(this.getClass());
    private int total = 500;
    private int success = 0;
    private int fail = 0;
    private int process = 0;
    private long startTime = 1495154212913l;

    private com.xaeport.cinsight.ui.engine.api.LoadApi loadApi = new com.xaeport.cinsight.ui.engine.api.LoadApi();

    public ResponseEntity<Object> getLoadReport(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        LoadReport loadReport = new LoadReport();
        loadReport.setFailCount(250);
        loadReport.setSuccessCount(250);
        loadReport.setTotalCount(500);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 250; i++) {
            list.add("D:/邮件数据/eml/20170425161022" + i + ".eml 格式错误，装载失败。");
        }
        loadReport.setFailFiles(list);
        return new ResponseEntity<Object>(loadReport, HttpStatus.OK);
    }

    public ResponseEntity<Object> getLoadState(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        LoadState loadState = new LoadState();
        loadState.setProgressLabel("正在装载 邮件" + process);
        loadState.setTotalCount(total);
        loadState.setSuccessCount(success);
        loadState.setFailCount(fail);
        loadState.setProcessCount(process);
        loadState.setStartTime(startTime);
        if (process < total) {
            process++;
            if (process % 2 == 0) {
                success++;
            } else {
                fail++;
            }
        }
        return new ResponseEntity<Object>(loadState, HttpStatus.OK);
    }

    public ResponseEntity<Object> loadMailData(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                               @NotNull @ApiParam(value = "插件名称", required = true) @RequestParam(value = "source", required = true) List<String> source,
                                               @NotNull @ApiParam(value = "配置项集合", required = true) @RequestParam(value = "options", required = true) List<String> options) {
        this.log.info("开始装载：caseId=" + caseId + " -source=" + source + " -options=" + options);
        this.startTime = System.currentTimeMillis();
        this.total = 500;
        this.success = 0;
        this.fail = 0;
        this.process = 0;

      /*  try {
            this.loadApi.load(source,options);
        } catch (ApiException e) {
             this.log.info("调用邮件转载接口 API 失败"+e);
            return new ResponseEntity(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }*/
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

    public ResponseEntity<List<Load>> selectLoadCaseOptionList(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {
        List<Load> loadList = new ArrayList<>();

        Load load1 = new Load();
        load1.setPluginName("压缩包");
        List<Option> optionList1 = new ArrayList<>();
        Option option11 = new Option();
        option11.setOptionKey("RARKEY");
        option11.setOptionLabel("RAR");
        option11.setOptionValue("RAR");
        Option option12 = new Option();
        option12.setOptionKey("ZIPKEY");
        option12.setOptionLabel("ZIP");
        option12.setOptionValue("ZIP");
        Option option13 = new Option();
        option13.setOptionKey("7ZKEY");
        option13.setOptionLabel("7Z");
        option13.setOptionValue("7Z");
        optionList1.add(option11);
        optionList1.add(option12);
        optionList1.add(option13);
        load1.setOptions(optionList1);

        Load load2 = new Load();
        load2.setPluginName("全文索引");
        List<Option> optionList2 = new ArrayList<>();
        Option option21 = new Option();
        option21.setOptionKey("PDFKEY");
        option21.setOptionLabel("PDF");
        option21.setOptionValue("PDF");
        Option option22 = new Option();
        option22.setOptionKey("WPSKEY");
        option22.setOptionLabel("WPS");
        option22.setOptionValue("WPS");
        Option option23 = new Option();
        option23.setOptionKey("HTMLKEY");
        option23.setOptionLabel("HTML");
        option23.setOptionValue("HTML");
        optionList2.add(option21);
        optionList2.add(option22);
        optionList2.add(option23);
        load2.setOptions(optionList2);

        Load load3 = new Load();
        load3.setPluginName("信息提取");
        List<Option> optionList3 = new ArrayList<>();
        Option option31 = new Option();
        option31.setOptionKey("CREATETIMEKEY");
        option31.setOptionLabel("创建时间");
        option31.setOptionValue("CREATETIME");
        Option option32 = new Option();
        option32.setOptionKey("AUTHORKEY");
        option32.setOptionLabel("文档作者");
        option32.setOptionValue("AUTHOR");
        Option option33 = new Option();
        option33.setOptionKey("COMPANYKEY");
        option33.setOptionLabel("文档公司");
        option33.setOptionValue("COMPANY");
        optionList3.add(option31);
        optionList3.add(option32);
        optionList3.add(option33);
        load3.setOptions(optionList3);

        Load load4 = new Load();
        load4.setPluginName("领域词库");
        List<Option> optionList4 = new ArrayList<>();
        Option option41 = new Option();
        option41.setOptionKey("CUSTOMSKEY");
        option41.setOptionLabel("海关");
        option41.setOptionValue("CUSTOMS");
        Option option42 = new Option();
        option42.setOptionKey("FINANCEKEY");
        option42.setOptionLabel("金融");
        option42.setOptionValue("FINANCE");
        Option option43 = new Option();
        option43.setOptionKey("ARCHIVESKEY");
        option43.setOptionLabel("文档");
        option43.setOptionValue("ARCHIVES");
        optionList4.add(option41);
        optionList4.add(option42);
        optionList4.add(option43);
        load4.setOptions(optionList4);
        loadList.add(load1);
        loadList.add(load2);
        loadList.add(load3);
        loadList.add(load4);
        return new ResponseEntity<List<Load>>(loadList, HttpStatus.OK);
    }

    public ResponseEntity<Object> stopLoadMail(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId) {

        this.log.info("停止装载：caseId=" + caseId);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
