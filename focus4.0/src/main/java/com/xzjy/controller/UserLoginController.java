package com.xzjy.controller;

import com.xzjy.mapper.UserMapper;
import com.xzjy.pojo.Users;
import com.xzjy.shiro.UserToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;

@Controller
public class UserLoginController {
    @Autowired
    private UserMapper mapper;

    @RequestMapping("/UserLoginController")
    public String doLogin(String uName, String uPassword, HttpSession session, Model model){
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
//        //封装用户的登录数据
        model.addAttribute("username",uName);
        try {
            subject.login(new UserToken(uName,uPassword,"User"));//执行登录
            Users user = mapper.login(uName);
            session.setAttribute("user",user);
            return "user/ownerService";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","账号错误");
            return "user/UsersLogin";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "user/UsersLogin";
        }
    }

}
