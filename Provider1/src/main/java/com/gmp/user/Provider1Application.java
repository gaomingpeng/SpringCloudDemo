package com.gmp.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient//声明这是一个eureka client
@SpringBootApplication
@MapperScan("com.gmp.*.mapper")//开启自动扫描mapper文件
public class Provider1Application {
    public static void main(String[] args) {
        SpringApplication.run(Provider1Application.class,args);
    }
}
