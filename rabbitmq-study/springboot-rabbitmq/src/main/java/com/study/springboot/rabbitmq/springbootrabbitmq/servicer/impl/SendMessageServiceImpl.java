package com.study.springboot.rabbitmq.springbootrabbitmq.servicer.impl;

import com.study.springboot.rabbitmq.springbootrabbitmq.Constants;
import com.study.springboot.rabbitmq.springbootrabbitmq.servicer.SendMessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Title: SendMessageServiceImpl
 * @ProjectName springboot_rabbit_mq
 * @Description: 发送消息业务层实现类
 * @Author WeiShiHuai
 * @Date 2018/9/20 14:59
 */
@Component
public class SendMessageServiceImpl implements SendMessageService {

    private static Logger logger = LoggerFactory.getLogger(SendMessageServiceImpl.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendMessage(Object message, String routKey) {
        //设置回调对象
        rabbitTemplate.setConfirmCallback(this);
        //构建回调返回的数据
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend(Constants.SAVE_USER_EXCHANGE_NAME, routKey, message, correlationData);
        logger.info("SendMessageServiceImpl() >>> 发送消息到RabbitMQ, 消息内容: " + message);
    }

    /**
     * 消息回调确认方法
     *
     * @param correlationData 回调数据
     * @param isSendSuccess   是否发送成功
     * @param
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean isSendSuccess, String s) {
        logger.info("confirm回调方法>>>>>>>>>>>>>回调消息ID为: " + correlationData.getId());
        if (isSendSuccess) {
            logger.info("confirm回调方法>>>>>>>>>>>>>消息发送成功");
        } else {
            logger.info("confirm回调方法>>>>>>>>>>>>>消息发送失败" + s);
        }

    }

}