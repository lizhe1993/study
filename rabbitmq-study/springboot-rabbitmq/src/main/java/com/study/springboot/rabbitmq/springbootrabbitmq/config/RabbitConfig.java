package com.study.springboot.rabbitmq.springbootrabbitmq.config;

import com.study.springboot.rabbitmq.springbootrabbitmq.Constants;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: RabbitConfig
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/6/19 15:06
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Configuration
public class RabbitConfig {

    /**
     * 配置交换机实例
     *
     * @return
     */
    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(Constants.SAVE_USER_EXCHANGE_NAME);
    }

    /**
     * 配置队列实例，并且设置持久化队列
     *
     * @return
     */
    @Bean
    public Queue queue() {
        return new Queue(Constants.SAVE_USER_QUEUE_NAME_1, true);
    }

    @Bean
    public Queue queue2() {
        return new Queue(Constants.SAVE_USER_QUEUE_NAME_2, true);
    }

    /**
     * 将队列绑定到交换机上，并设置消息分发的路由键
     *
     * @return
     */
    @Bean
    public Binding binding() {
        //链式写法: 用指定的路由键将队列绑定到交换机
        return BindingBuilder.bind(queue()).to(directExchange()).with(Constants.SAVE_USER_QUEUE_ROUTE_KEY_1);
    }

    /**
     * 将队列绑定到交换机上，并设置消息分发的路由键
     *
     * @return
     */
    @Bean
    public Binding binding2() {
        //链式写法: 用指定的路由键将队列绑定到交换机
        return BindingBuilder.bind(queue2()).to(directExchange()).with(Constants.SAVE_USER_QUEUE_ROUTE_KEY_2);
    }
}
