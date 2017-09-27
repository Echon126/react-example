package com.xaeport.cinsight.ui.controller;

import com.xaeport.cinsight.ui.api.SearchApi;
import com.xaeport.cinsight.ui.engine.ApiException;
import com.xaeport.cinsight.ui.engine.model.Search;
import io.swagger.annotations.ApiParam;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class SearchApiController implements SearchApi {

    private Log log = LogFactory.getLog(this.getClass());

    private com.xaeport.cinsight.ui.engine.api.SearchApi searchApi = new com.xaeport.cinsight.ui.engine.api.SearchApi();

    public ResponseEntity<Object> getSearchDataCount(@ApiParam(value = "案件id", required = true) @PathVariable("caseId") String caseId,
                                                     @ApiParam(value = "检索条件") @RequestParam(value = "conditions", required = false) String conditions) {
        this.log.info("调用检索查询总数api：caseId=" + caseId + " -conditions=" + conditions);
        Search search = null;
        try {
            search = searchApi.search(conditions);
        } catch (ApiException e) {
            this.log.error("检索总数API 调用失败", e);
            return new ResponseEntity<Object>(e.getResponseBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<Object>(search, HttpStatus.OK);
    }

}
