package com.product.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan("com.product.service")
@MapperScan("com.product.service.mapper")
public class MallProductServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallProductServiceApplication.class, args);
    }
}
