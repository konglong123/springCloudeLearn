package com.kong.baseInterface;
import com.kong.entity.Order;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: demo-feign-base
 * @description: feign继承改善项目架构，测试，订单服务
 * @author: Mr.Kong
 * @create: 2019-09-14 16:34
 **/
public interface OrderServiceInterface {
    @RequestMapping(value = "getOrder",method = RequestMethod.GET)
    Order getOrderById(@RequestHeader("id") String id);

}
