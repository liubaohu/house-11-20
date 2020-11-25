package com.kgc.house.controller;

import com.kgc.house.pojo.User;
import com.kgc.house.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Controller
public class UserController {
    @Resource
    UserService userService;
    @PostMapping(value = "/login3")
    @ResponseStatus(value = HttpStatus.OK)
    public void login(@RequestParam("cardId")String cardId, @RequestParam("password")String password, HttpServletResponse response, HttpServletRequest request) throws ServletException, IOException {
        System.out.println("aaaa");
        User user = userService.selectByCardIdAndPassword(cardId, password);
        if (user!=null && user.getStatus()==1){
            request.getSession().setAttribute("user",user);
            request.getRequestDispatcher("/select").forward(request,response);
        }else if (user==null){
            response.getWriter().print("<script>alert('身份证或密码错误');location.href='/login.jsp';</script>");
        }else {
            response.getWriter().print("<script>alert('账号已被冻结!!!');location.href='/login.jsp';</script>");
        }
    }
    @RequestMapping(value = "/login2",method = {RequestMethod.POST,RequestMethod.GET})
    public String login2(@RequestParam("cardId")String cardId, @RequestParam("password")String password,Model model, HttpSession session)  {
        System.out.println(cardId);
        User user = userService.selectByCardIdAndPassword(cardId, password);
        if (user!=null && user.getStatus()==1){
            session.setAttribute("user",user);
            return "forward:/select";
        }else if (user==null){
            model.addAttribute("msg","用户名或密码错误");
            return "forward:/login.jsp";
        }else {
            model.addAttribute("msg","账号已被冻结");
            return "forward:/login.jsp";
        }
    }
    //跳转select页面
    @RequestMapping("/select")
    public String selectJsp(){
        return "select";
    }
    @PostMapping("/register")
    public String register(User user){
        Date date = new Date();
        user.setCreateTime(date);
        String s = user.getCardId().substring(17);
        user.setGender(Integer.parseInt(s.trim()));
        Integer integer = userService.addUser(user);
        return "forward:/select";
    }
}
