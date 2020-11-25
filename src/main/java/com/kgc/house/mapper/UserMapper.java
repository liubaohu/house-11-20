package com.kgc.house.mapper;

import com.kgc.house.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public User selectByCardIdAndPassword(@Param("cardId") String cardId,@Param("password") String password);
    public Integer addUser(User user);
    public User selectByName(String name);

}
