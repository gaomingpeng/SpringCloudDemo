package com.gmp.user.service;

import com.gmp.user.entity.User;
import com.gmp.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public  User selectByPrimaryKey (int id){
        return  userMapper.selectByPrimaryKey(id);
    }
}
