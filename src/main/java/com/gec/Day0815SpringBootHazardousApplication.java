package com.gec;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day0815SpringBootHazardousApplication {

    public static void main(String[] args) {
        System.out.println("你好");
        SpringApplication.run(Day0815SpringBootHazardousApplication.class, args);
    }

}
