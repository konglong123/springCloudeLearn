package com.kong.demoeurekaservercaller.demoeurekaservercaller.controller;

import com.kong.demoeurekaservercaller.demoeurekaservercaller.entity.RibbonPing;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
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
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
    @Bean
    public IPing ribbonPing(){
        return new RibbonPing();
    }
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        loadBalancerClient.choose("sayHello");
        RestTemplate restTemplate=getRestTemplate();
        String val=restTemplate.getForEntity("http://sayHello/hello/Eureka",String.class).getBody();
        return "In caller "+val;
    }
}
