package com.web.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.web.news.mapper")
@EnableEurekaClient
public class NewsEditApp {
    public static void main(String[] args) {
        SpringApplication.run(NewsEditApp.class, args);
    }
}
