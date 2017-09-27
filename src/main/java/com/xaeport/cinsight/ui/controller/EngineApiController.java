package com.xaeport.cinsight.ui.controller;


import com.xaeport.cinsight.ui.api.EngineApi;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")

@Controller
public class EngineApiController implements EngineApi {

    private Log log = LogFactory.getLog(this.getClass());

    public ResponseEntity<Object> safeLogout() {
        this.log.info("api安全退出");
        return new ResponseEntity<Object>(HttpStatus.OK);
    }

}
