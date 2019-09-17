package com.kong.demofeignribbon;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class DemoFeignRibbonApplication {
    //定义日志输出的级别
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoFeignRibbonApplication.class, args);
    }

}
