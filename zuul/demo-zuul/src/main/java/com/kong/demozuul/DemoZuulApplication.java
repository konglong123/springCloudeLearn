package com.kong.demozuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
//低版本的zuul包，缺少相应注解
@SpringBootApplication
@EnableZuulProxy
public class DemoZuulApplication {
    @Bean
    public MyZuulFilter myZuulFilter(){
        return new MyZuulFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoZuulApplication.class, args);
    }

}
