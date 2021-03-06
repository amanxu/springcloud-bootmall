package com.mall.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients

@ComponentScan("com.mall.order")
@MapperScan("com.mall.order.mapper")
public class MallOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallOrderServiceApplication.class, args);
    }
}
