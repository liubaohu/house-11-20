package com.kgc.house.service.impl;

import com.kgc.house.mapper.UserMapper;
import com.kgc.house.pojo.User;
import com.kgc.house.service.UserService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public User selectByCardIdAndPassword(String cardId, String password) {
        User user = userMapper.selectByCardIdAndPassword(cardId, password);
        return user;
    }

    @Override
    public Integer addUser(User user) {
        Integer integer = userMapper.addUser(user);
        return integer;
    }

    @Override
    public User selectByName(String name) {
        User user = userMapper.selectByName(name);
        return user;
    }
}
