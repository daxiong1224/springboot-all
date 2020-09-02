package com.hx.exception.controller;

import com.hx.exception.handle.AgeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @RequestMapping("/test")
    public String test() {
        int i = 1 / 0;
        return "test";
    }

    @RequestMapping("/ageTest")
    @ResponseBody
    public String ageTest(int age) {
        if (age > 16) {
            throw new AgeException("999", "传入年龄不能大于16");
        }
        return "test";
    }
}
