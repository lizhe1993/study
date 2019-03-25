package com.lz.redis.study.redisstudy;

import com.sun.media.sound.SoftTuning;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisStudyApplicationTests {

    private static Jedis jedis;

    static {
        //连接本地的 Redis 服务
        jedis = new Jedis("localhost",6379);
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

    @Test
    public void testConnect(){
        String select = jedis.select(0);
        System.out.println(select);
    }

    @Test
    public void testSet(){
        jedis.set("username", "LiZhe");
        String username = jedis.get("username");
        Assert.assertEquals(username,"LiZhe");
    }

    @Test
    public void testKeys(){
        Set<String> keys = jedis.keys("*");
        for(String key:keys){
            System.out.println(key);
        }
    }

    @Test
    public void testExists(){
        Boolean username = jedis.exists("username");
        Assert.assertEquals(username,true);
    }

    @Test
    public void testDel(){
        long username = jedis.del("username");
        Assert.assertEquals(username,1L);
    }

    @Test
    public void testTypeKey(){
        String username = jedis.type("username");
        System.out.println(username);
    }

    @Test
    public void testLPush(){
        Long bar = jedis.lpush("bar", "1");
        System.out.println(bar);
        String username = jedis.type("bar");
        System.out.println(username);
    }


}
