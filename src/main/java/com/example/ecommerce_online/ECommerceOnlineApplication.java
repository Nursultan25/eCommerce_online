package com.example.ecommerce_online;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ECommerceOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceOnlineApplication.class, args);
    }

}
