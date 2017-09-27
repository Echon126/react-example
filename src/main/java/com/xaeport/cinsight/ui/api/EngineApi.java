package com.xaeport.cinsight.ui.api;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-05-16T08:42:06.175Z")
@RequestMapping(value = "/v10")
@Api(value = "engine", description = "the engine API")
public interface EngineApi {

    @ApiOperation(value = "安全退出", notes = "安全退出，向引擎发送停止指令，异步接口,并关闭浏览器", response = Object.class, tags={ "logout", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "操作成功", response = Object.class),
        @ApiResponse(code = 400, message = "操作失败", response = Object.class) })
    @RequestMapping(value = "/engine",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Object> safeLogout();

}
