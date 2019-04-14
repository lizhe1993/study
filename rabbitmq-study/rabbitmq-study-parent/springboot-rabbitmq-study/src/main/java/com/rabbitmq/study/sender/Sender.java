package com.rabbitmq.study.sender;

import com.rabbitmq.study.config.RabbitMQConfig2;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author 李哲 【wb71@yingu.com】
 * @Date 2017/11/14 14:34
 */
@Service
public class Sender {

    @Autowired
    private AmqpTemplate rt;

    public void send(){
        System.out.println("李哲 发送消息.....");
        rt.convertAndSend(RabbitMQConfig2.QUEUE_NAME,"你好，李哲！");
    }

}
