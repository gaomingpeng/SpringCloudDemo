package com.gmp.user.controller;

import com.gmp.user.entity.User;
import com.gmp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable int id){
        return this.userService.selectByPrimaryKey(id);
    }
}
