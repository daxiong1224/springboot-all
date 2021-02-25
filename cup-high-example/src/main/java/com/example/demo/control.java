package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class control {

    @GetMapping(value = "/RunService", produces = "application/json;charset=UTF-8")
    public void handleRequest(Integer num) throws Exception {
        cpuHigh(num);
    }

    public static void cpuHigh(Integer num) {
        final List<String> list = new LinkedList<>();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 1;
                while (count<num) {
                    // 构造thread1为消耗很高cpu的线程
                    count = count + 1;
                    System.out.println("count值：" + count);
                }
            }
        });
        thread1.setName("thread1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // 构造thread2为消耗很低cpu的线程
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.setName("thread2");
        thread1.start();
        thread2.start();
    }
}
