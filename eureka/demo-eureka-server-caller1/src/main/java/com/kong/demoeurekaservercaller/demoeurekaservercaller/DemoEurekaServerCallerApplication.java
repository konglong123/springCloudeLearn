package com.kong.demoeurekaservercaller.demoeurekaservercaller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class DemoEurekaServerCallerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaServerCallerApplication.class, args);
    }

}
