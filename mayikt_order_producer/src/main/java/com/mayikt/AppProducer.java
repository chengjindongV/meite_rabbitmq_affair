package com.mayikt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: AppProducer
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/12/1721:57
 */
@SpringBootApplication
@MapperScan("com.mayikt.mapper")
//@EnableAsync
public class AppProducer {

    public static void main(String[] args) {
        SpringApplication.run(AppProducer.class);
    }
}
