package com.hx.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户相关接口", description = "提供用户相关的 Rest API")
@RestController
@RequestMapping("/hx")
public class HelloController {
    
    @ApiOperation(value= "这里你好接口")
    @GetMapping("/hello")
    public String hello(@RequestParam String request){
        return "你好" + request;
    }
}
