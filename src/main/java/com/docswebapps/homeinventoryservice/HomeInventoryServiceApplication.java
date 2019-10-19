package com.docswebapps.homeinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HomeInventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeInventoryServiceApplication.class, args);
    }

}
