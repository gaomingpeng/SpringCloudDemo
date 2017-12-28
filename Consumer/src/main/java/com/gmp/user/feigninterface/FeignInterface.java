package com.gmp.user.feigninterface;

import com.gmp.config.FeignConfiguration;
import com.gmp.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 采用feign自带的注解
 */
@FeignClient(name="provider",configuration = FeignConfiguration.class)
public interface FeignInterface {
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") int id);
}
