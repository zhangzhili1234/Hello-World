package com.zzl.cusumer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.zzl.**.mapper")
@SpringBootApplication(scanBasePackages = "com.zzl.**")
public class CusumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CusumerApplication.class, args);
    }

}
