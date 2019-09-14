package com.kong.demoeurekaclient1.demoeurekaclientone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoEurekaClientOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClientOneApplication.class, args);
    }

}
