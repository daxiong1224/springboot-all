package com.example.springsecurity.controller;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ResourceController {
    @Autowired
    private RedissonClient redissonClient;

    /**
     * 测试自动装配RedissonClient。
     * @return
     */
    @RequestMapping("echo2")
    public String echo2(){
        String s = null;
        try {
            s = redissonClient.getConfig().toYAML();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @RequestMapping("/r/r1")
    public String r1(){
        return "访问资源1";
    }

    @RequestMapping("/r/r2")
    public String r2(){
        return "访问资源2";
    }
}
