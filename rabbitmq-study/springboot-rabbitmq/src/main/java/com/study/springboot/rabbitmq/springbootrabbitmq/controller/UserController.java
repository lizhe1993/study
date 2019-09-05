package com.study.springboot.rabbitmq.springbootrabbitmq.controller;


import com.study.springboot.rabbitmq.springbootrabbitmq.model.UserEntity;
import com.study.springboot.rabbitmq.springbootrabbitmq.servicer.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/sendMessage")
    public void sendMessage() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(20);
        userEntity.setName("zhangsan");
        userService.saveUser(userEntity);
    }

    @RequestMapping("/sendMessage2")
    public void sendMessage2() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(20);
        userEntity.setName("zhangsan");
        userService.saveUser2(userEntity);
    }

    @RequestMapping("/sendMessage3")
    public void sendMessage3() {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(20);
        userEntity.setName("zhangsan");
        userService.saveUser3(userEntity);
    }
}
