package com.kong.demoeurekaservercaller.demoeurekaservercaller.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: demo-eureka-server-caller1
 * @description: 测试，请求服务
 * @author: Mr.Kong
 * @create: 2019-09-10 10:23
 **/
@RestController
@Configuration
public class callHelloController {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        RestTemplate restTemplate=getRestTemplate();
        String retval=restTemplate.getForEntity("http://sayHello/hello/Eureka",String.class).getBody();
        return "In caller"+retval;
    }
}
