package com.kgc.house.service;

import com.kgc.house.pojo.User;

public interface UserService {
    //登录
    public User selectByCardIdAndPassword(String cardId, String password);
    public Integer addUser(User user);

    public User selectByName(String name);
}
