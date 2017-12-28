package com.gmp.user.feigninterface;

import com.gmp.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name="provider")
public interface UserFeignClient  {

    @GetMapping (value = "/{id}")
    public User findByID(@PathVariable("id") int  id);

}
