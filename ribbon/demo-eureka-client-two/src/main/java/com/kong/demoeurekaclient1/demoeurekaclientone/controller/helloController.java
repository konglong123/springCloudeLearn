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
    @Autowired
    private DiscoveryClient discoveryClient;

    //服务注册接口，包含了获取服务(本服务的)ID的方法。
    @Resource
    private Registration registration;

    @RequestMapping(value = "/hello/{username}",method = RequestMethod.GET)
    public String sayHello(@PathVariable("username")String username){
        StringBuilder sb=new StringBuilder();
        String serverId=registration.getServiceId();
        List<ServiceInstance> instance=discoveryClient.getInstances(serverId);
        for (ServiceInstance si:instance){
            sb.append(si.getHost()+":"+si.getPort()+"two\n");
        }
        return sb.toString();
    }

}
