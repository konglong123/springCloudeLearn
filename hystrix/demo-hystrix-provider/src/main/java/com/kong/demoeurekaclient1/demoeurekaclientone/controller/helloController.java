package com.kong.demoeurekaclient1.demoeurekaclientone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: demo-eureka-client-one
 * @description: 测试，输出Eureka服务器相关信息
 * @author: Mr.Kong
 * @create: 2019-09-10 08:40
 **/
@RestController
public class helloController {
    @RequestMapping(value = "available",method = RequestMethod.GET)
    public String availableService(){
        return "this is available.";
    }

    @RequestMapping(value = "unavailable",method = RequestMethod.GET)
    public String unavailableS(){
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "this is unavailable.";
    }

}
