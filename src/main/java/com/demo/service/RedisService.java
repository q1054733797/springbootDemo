package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RedisService
 * @Author: zhanghongkai
 * @Date: Create in 2018/10/11 10:47
 * @Version: 1.0
 */
@Service("redisService")
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;

    public void setKeyValue(String key,String value){
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

    public void delKey(String key){
        redisTemplate.delete(key);
    }
}
