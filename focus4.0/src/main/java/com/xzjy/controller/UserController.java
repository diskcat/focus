package com.xzjy.controller;

import com.xzjy.mapper.UserMapper;
import com.xzjy.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/UserController")
    public Object doMain(HttpServletRequest request){
        String method = request.getParameter("method");
        if(method.equals("findAll")){
            return findAll(request);
        }else if("add".equals(method)){
            return add(request);
        }else if("delete".equals(method)){
            return delete(request);
        }else if("update".equals(method)){
            return update(request);
        }
        return null;
    }

    private String delete(HttpServletRequest request) {
        String uIdStr = request.getParameter("uIdStr");
        String[] uIds = uIdStr.split(",");
        try {
            for (String uId : uIds) {
                userMapper.delete(uId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private String add(HttpServletRequest request) {
        Users users = getUsers(request);
        try {
            userMapper.add(users);
            return "success";
        } catch (Exception e){
            return "failure";
        }
    }

    private String update(HttpServletRequest request) {
        Users users = getUsers(request);
        try {
            userMapper.update(users);
            return "success";
        } catch (Exception e){
            return "failure";
        }
    }


    private Map findAll(HttpServletRequest request) {
        int page = Integer.parseInt(request.getParameter("page"));
        int rows = Integer.parseInt(request.getParameter("rows"));
        int num = (page-1)*rows;
        String uId = request.getParameter("uId");
        String uName = request.getParameter("uName");
        List<Users> users = userMapper.findAll(num,rows,uId,uName);
        int totals = userMapper.count(uId,uName);
        Map map = new HashMap<String,Object>();
        map.put("total",totals);
        map.put("rows",users);
        return map;
    }

    Users getUsers(HttpServletRequest request){
        String uId = request.getParameter("uId");
        String uName = request.getParameter("uName");
        String uPassword = request.getParameter("uPassword");
        String uEmail = request.getParameter("uEmail");
        Users user = new Users(uId,uName,uPassword,uEmail);
        return user;
    }


}
