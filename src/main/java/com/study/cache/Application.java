package com.study.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.study.cache.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
        System.out.println("=================启动================");
    }
}
