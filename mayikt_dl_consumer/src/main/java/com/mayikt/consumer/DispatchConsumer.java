package com.mayikt.consumer;

import com.alibaba.fastjson.JSONObject;
import com.mayikt.entity.DispatchEntity;
import com.mayikt.mapper.DispatchMapper;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 蚂蚁课堂创始人-余胜军QQ644064779
 * @title: DispatchConsumer
 * @description: 每特教育独创第五期互联网架构课程
 * @date 2019/12/1721:48
 */
@Component
public class DispatchConsumer {
    @Autowired
    private DispatchMapper dispatchMapper;

    @RabbitListener(queues = "order_dic_queue")
    public void dispatchConsumer(Message message, Channel channel) throws IOException {
        // 1.获取消息
        String msg = new String(message.getBody());
        // 2.转换json
        JSONObject jsonObject = JSONObject.parseObject(msg);
        String orderId = jsonObject.getString("orderId");
        // 计算分配的快递员id
        DispatchEntity dispatchEntity = new DispatchEntity(orderId, 1234L);
        // 3.插入我们的数据库
        int result = dispatchMapper.insertDistribute(dispatchEntity);
        if (result > 0) {
            // 手动将该消息删除
            // 手动ack 删除该消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }

    }
}
