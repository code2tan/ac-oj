package com.ghost.acoj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@MapperScan("com.ghost.acoj.mapper")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.ghost.acoj.service"})
public class AcOjBackendUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AcOjBackendUserServiceApplication.class, args);
    }

}
