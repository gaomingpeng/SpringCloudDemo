package com.gmp.user;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
@EnableEurekaClient//EurekaClient
@SpringBootApplication
@EnableFeignClients//启用feign
@EnableHystrix//启动短路支持
public class ConsumerApplication {
/*    @Bean
    @LoadBalanced//此注解可以使此bean具备负载均衡的能力
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }*/
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
