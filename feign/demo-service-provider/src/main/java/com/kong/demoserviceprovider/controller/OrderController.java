package com.kong.demoserviceprovider.controller;

import com.kong.baseInterface.OrderServiceInterface;
import com.kong.entity.Order;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: demo-service-provider
 * @description:
 * @author: Mr.Kong
 * @create: 2019-09-14 16:52
 **/
@RestController
public class OrderController implements OrderServiceInterface {
    @Override
    public Order getOrderById(String id) {
        Order order=new Order();
        order.setOrderId(id);
        order.setAmount(100);
        order.setOwner("kong");
        return order;
    }
}
