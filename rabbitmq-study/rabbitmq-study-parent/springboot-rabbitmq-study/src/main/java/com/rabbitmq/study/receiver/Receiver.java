package com.rabbitmq.study.receiver;

import com.rabbitmq.study.config.RabbitMQConfig2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 李哲 【wb71@yingu.com】
 * @Date 2017/11/14 14:40
 */
@Service
public class Receiver {

    @Autowired
    private AmqpTemplate rt;

    @RabbitListener(queues = RabbitMQConfig2.QUEUE_NAME)
    public void receiveMessage(String message){
        System.out.println("接收到：【"+message+"】");
    }

}
