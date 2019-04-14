package com.rabbitmq.study.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 李哲 【wb71@yingu.com】
 * @Date 2017/11/14 14:32
 */
//@Configuration
public class RabbitMQConfig {
    public static final String QUEUE_NAME = "spring-boot-simple";

    @Bean
    public Queue queue(){
        return new Queue(QUEUE_NAME);
    }
}
