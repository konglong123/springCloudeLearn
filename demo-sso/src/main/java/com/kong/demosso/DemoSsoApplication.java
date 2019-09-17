package com.kong.demosso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoSsoApplication {
    @Bean
    public RedisUtil getRedisUtil(){
        return new RedisUtil();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoSsoApplication.class, args);
    }

}
