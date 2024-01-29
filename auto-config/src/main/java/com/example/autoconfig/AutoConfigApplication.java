package com.example.autoconfig;

import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class AutoConfigApplication {



    public static void main(String[] args) {
        SpringApplication.run(AutoConfigApplication.class, args);

    }

}
