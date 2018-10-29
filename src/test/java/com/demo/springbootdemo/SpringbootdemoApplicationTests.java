package com.demo.springbootdemo;

import com.demo.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootdemoApplicationTests {
    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void redis(){
        redisService.setKeyValue("name", "张三");
        System.out.println(redisService.getValue("name"));
        redisService.delKey("name");
        System.out.println(redisService.getValue("name"));
        redisTemplate.delete("users");
    }

}
