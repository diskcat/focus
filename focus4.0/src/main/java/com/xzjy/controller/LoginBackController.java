package com.xzjy.controller;

import com.xzjy.mapper.InformationMapper;
import com.xzjy.pojo.Information;
import com.xzjy.pojo.Users;
import com.xzjy.shiro.UserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginBackController {
    @Autowired
    private InformationMapper informationMapper;
    @RequestMapping("/LoginBackController")
    public String doLogin(HttpServletRequest request, HttpSession session, Model model){
        String backId=request.getParameter("backId");
        String backPwd=request.getParameter("backPwd");
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
//        //封装用户的登录数据
        model.addAttribute("username",backId);
        try {
            subject.login(new UserToken(backId,backPwd,"Admin"));//执行登录
            Information admin = informationMapper.login(backId);
            session.setAttribute("user",admin);
            return "admin/BackIndex";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","账号错误");
            return "admin/BackLogin";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "admin/BackLogin";
        }

    }
}
