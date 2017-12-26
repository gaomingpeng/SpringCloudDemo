package com.gmp.user.controller;

import com.gmp.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${Url}")
     private  String Url;
    @GetMapping("/user/{id}")
    public User findById(@PathVariable int  id){

        return this.restTemplate.getForObject(Url+id,User.class);
    }
}
