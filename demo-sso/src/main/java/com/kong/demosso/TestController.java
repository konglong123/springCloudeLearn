package com.kong.demosso;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: demo-sso
 * @description:
 * @author: Mr.Kong
 * @create: 2019-09-16 18:52
 **/
@RestController
public class TestController {
    @Resource
    private RedisUtil redisUtil;

    @RequestMapping(value = "/helloAdd",method = RequestMethod.GET)
    public void setRedisValue(){
        redisUtil.valueAdd();
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object getRedisValue(){
        return redisUtil.valueGet();
    }

}
