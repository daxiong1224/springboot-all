package com.example.autoconfig.fing;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private RedissonClient redissonClient;

    @RequestMapping("/echo")
    public @ResponseBody
    String echo() {
        long now = new Date().getTime();
        try {
            String s = redissonClient.getConfig().toYAML();
            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new SimpleDateFormat().format(Calendar.getInstance().getTime());
    }
}
