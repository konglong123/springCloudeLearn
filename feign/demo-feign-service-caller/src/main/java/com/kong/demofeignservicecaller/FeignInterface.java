package com.kong.demofeignservicecaller;

import com.kong.baseInterface.OrderServiceInterface;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @program: demo-feign-service-caller
 * @description:每个外部工程的服务都对应一个Feign接口，通过controller进行调用
 * @author: Mr.Kong
 * @create: 2019-09-16 09:09
 **/
@FeignClient(value = "serviceProvider")
public interface FeignInterface extends OrderServiceInterface {
}
