package com.yikai.demoeasyexcel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.yikai.demoeasyexcel.mapper")
public class DemoEasyexcelApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEasyexcelApplication.class, args);
    }

}
