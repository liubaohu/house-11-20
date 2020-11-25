package com.kgc.house.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.house.pojo.RealEstate;
import com.kgc.house.pojo.User;
import com.kgc.house.service.RealEstateService;
import com.kgc.house.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.jws.WebParam;

@Controller
public class RealEstateController {
    @Resource
    RealEstateService realEstateService;
    @Resource
    UserService userService;
    @RequestMapping("/selectReal")
    public String selectRealEstate(@RequestParam(value = "selectType",required = false)String selectType,
                                   @RequestParam(value = "chaxun",required = false)String chaxun,
                                   @RequestParam(value = "pageNum",required = false) Integer pageNum,
                                   @RequestParam(value = "pageSize",required = false) Integer pageSize, Model model){
        if (pageNum==null){
            pageNum=1;
        }
        if (pageSize==null){
            pageSize=3;
        }
        if (selectType==null || selectType=="all"){
            PageInfo<RealEstate> pageInfo = realEstateService.selectRealEstate(pageNum, pageSize);
            for (RealEstate realEstate : pageInfo.getList()) {
                System.out.println(realEstate.toString());
            }
            model.addAttribute("pageInfo",pageInfo);
            System.out.println("asdasfaf");
            System.out.println(selectType);
            return "show";
        } else if (selectType.equals("cardId")){
            PageInfo<RealEstate> pageInfo = realEstateService.selectByCard(chaxun, pageNum, pageSize);
            if(pageInfo.getList()==null){
                model.addAttribute("msg","抱歉，没有此数据信息");
            }
            model.addAttribute( "pageInfo",pageInfo);
            return "show";
        }else {
            User user = userService.selectByName(chaxun);
            if (user==null){
                model.addAttribute("msg","抱歉，没有此数据信息");
            }
            PageInfo<RealEstate> pageInfo = realEstateService.selectByCard(user.getCardId(), pageNum, pageSize);
            model.addAttribute("pageInfo",pageInfo);
            return "show";
        }

    }
}
