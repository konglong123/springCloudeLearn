package com.kong.demofeignribbon;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: demo-feign-service-caller
 * @description:每个外部工程的服务都对应一个Feign接口，通过controller进行调用
 * @author: Mr.Kong
 * @create: 2019-09-16 09:09
 **/
@FeignClient(value = "sayHello")
public interface FeignInterface{
    //此处声明requestMapping和调用的服务中一一致即可，方法名不需要一样
    @RequestMapping(value = "/hello/{username}",method = RequestMethod.GET)
    String hello(@PathVariable("username")String username);
}
