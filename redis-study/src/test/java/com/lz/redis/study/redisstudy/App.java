package com.redis.study;

import redis.clients.jedis.Jedis;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        //连接本地的 Redis 服务
        getJedis();
        System.out.println( "Hello World!" );
    }


    public static Jedis getJedis(){
        Jedis jedis = new Jedis("192.168.2.14",6379);
        jedis.auth("redis");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        return jedis;
    }
}
