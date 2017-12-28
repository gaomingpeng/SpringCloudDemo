package com.gmp.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    //springcloud默认使用契约是springMVCcontract,是为了支持SpringMVC注册

   /* @Bean
    //将契约改成feign原生的默认契约
    public Contract feignContract(){
        return new feign.Contract.Default();
    }*/
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
