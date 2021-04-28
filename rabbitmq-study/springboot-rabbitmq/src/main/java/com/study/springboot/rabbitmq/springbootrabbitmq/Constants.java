package com.study.springboot.rabbitmq.springbootrabbitmq;

/**
 * ClassName: Constants
 * Description:
 * Date: 2019/6/19 15:07
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class Constants {

    //保存用户-交换机名称
    public static final String SAVE_USER_EXCHANGE_NAME = "test.user.save.direct.exchange.name";
    //保存用户-队列名称
    public static final String SAVE_USER_QUEUE_NAME_1 = "test.user.save.queue.name";

    public static final String SAVE_USER_QUEUE_NAME_2= "test.user.save.queue.name_2";


    //保存用户-队列路由键
    public static final String SAVE_USER_QUEUE_ROUTE_KEY_1 = "test.key_1";

    public static final String SAVE_USER_QUEUE_ROUTE_KEY_2 = "test.key_2";





}
