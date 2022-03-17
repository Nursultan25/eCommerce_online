package com.example.ecommerce_online;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class ECommerceOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceOnlineApplication.class, args);
    }

}
