package com.kgc.house.test;

import com.github.pagehelper.PageInfo;
import com.kgc.house.pojo.RealEstate;
import com.kgc.house.pojo.User;
import com.kgc.house.service.RealEstateService;
import com.kgc.house.service.UserService;
import com.kgc.house.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

public class Test01 {
    @Test
    public void Test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);
        User user = userServiceImpl.selectByCardIdAndPassword("123456789123456789", "123456");
        System.out.println(user.getGender());
    }
    @Test
    public void Test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RealEstateService realEstateServiceImpl = context.getBean("realEstateServiceImpl", RealEstateService.class);
        PageInfo<RealEstate> pageInfo = realEstateServiceImpl.selectByCard("123456789123456789", 1, 4);
        for (RealEstate realEstate : pageInfo.getList()) {
            System.out.println(realEstate.getUser().getName());
        }
    }
    @Test
    public void Test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userServiceImpl = context.getBean("userServiceImpl", UserService.class);
        User lbh = userServiceImpl.selectByName("lbh");
        System.out.println(lbh.getGender());
    }
}
