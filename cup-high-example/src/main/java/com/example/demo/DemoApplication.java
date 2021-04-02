package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("执行测试方法。。。");
        
//        //堆溢出
//       heap();
        
        //栈溢出
//        stack();
        
//        cpuHigh();
//        System.out.println("测试方法执行结束。。。");
    }
    
    public void heap() {
        List<Object> list= new ArrayList<>();
        while (true) {
            System.out.println("长度:" + list.size());
            list.add(new Object());
        }
    }
    
    public void stack() {
        stack();
    }

    public static void cpuHigh() {
        final List<String> list = new LinkedList<>();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 1;
                while (true) {
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
