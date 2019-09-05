package com.study.springboot.rabbitmq.springbootrabbitmq.servicer;


import com.study.springboot.rabbitmq.springbootrabbitmq.Constants;
import com.study.springboot.rabbitmq.springbootrabbitmq.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: UserService
 * @ProjectName springboot_rabbit_mq
 * @Description: 用户业务层接口
 * @Author WeiShiHuai
 * @Date 2018/9/20 14:25
 */
@Service
public class UserService {

    @Autowired
    private SendMessageService sendMessageService;

    @Transactional
    public Long saveUser(UserEntity userEntity) {
        //保存用户操作
        //这里写保存数据库操作...

        //发送消息到RabbitMQ
        sendMessageService.sendMessage(userEntity.getName(),Constants.SAVE_USER_QUEUE_ROUTE_KEY_1);
        return userEntity.getId();
    }

    @Transactional
    public Long saveUser2(UserEntity userEntity) {
        //保存用户操作
        //这里写保存数据库操作...

        //发送消息到RabbitMQ
        sendMessageService.sendMessage(userEntity.getName(),Constants.SAVE_USER_QUEUE_ROUTE_KEY_2);
        return userEntity.getId();
    }

    @Transactional
    public Long saveUser3(UserEntity userEntity) {
        //保存用户操作
        //这里写保存数据库操作...

        //发送消息到RabbitMQ
        sendMessageService.sendMessage(userEntity.getName(),null);
        return userEntity.getId();
    }
}
