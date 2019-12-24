package com.mayikt.controller;

import com.mayikt.producer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: OrderController
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/12/1721:56
 */
@RestController
public class OrderController {
    @Autowired
    private OrderProducer orderProducer;

    @RequestMapping("/sendOrder")
    public String sendOrder() {
        return orderProducer.sendOrder();
    }
}
