package com.kong.demosso;

import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

/**
 * @program: demo-sso
 * @description:测试redis的操作
 * @author: Mr.Kong
 * @create: 2019-09-16 18:49
 **/
public class RedisUtil {
    @Resource
    private RedisTemplate redisTemplate;

    public void valueAdd(){
        redisTemplate.opsForValue().set("key","hehhe");
    }
    public Object valueGet(){
        Object value = redisTemplate.opsForValue().get("key");
        return value;
    }

}
