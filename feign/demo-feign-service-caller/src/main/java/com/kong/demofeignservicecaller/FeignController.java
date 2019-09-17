package com.kong.demofeignservicecaller;

import com.kong.entity.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @program: demo-feign-service-caller
 * @description:
 * @author: Mr.Kong
 * @create: 2019-09-16 09:45
 **/
@RestController
public class FeignController {
    @Resource
    private FeignInterface feignInterface;
    @RequestMapping(value = "/getOrder",method = RequestMethod.GET)
    public Order getOrder(){
        return feignInterface.getOrderById("0001");
    }

}
