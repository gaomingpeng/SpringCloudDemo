package com.gmp.user.feigninterface;

import com.gmp.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.jws.soap.SOAPBinding;


@FeignClient(name="provider",fallback = FeignClientFallback.class)
public interface UserFeignClient  {

    @GetMapping (value = "/{id}")
    public User findByID(@PathVariable("id") int  id);

}

/**
 * 为feign加上hystrix
 */
@Component
class FeignClientFallback implements  UserFeignClient{
    @Override
    public User findByID(int id) {
        User user = new User();
        user.setId(1);
        user.setName("请求失败！");
        return user;
    }
}