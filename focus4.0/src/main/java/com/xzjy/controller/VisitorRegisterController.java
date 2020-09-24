package com.xzjy.controller;

import com.xzjy.mapper.VisitorRegisterMapper;
import com.xzjy.pojo.VisitorRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class VisitorRegisterController {
    @Autowired
    private VisitorRegisterMapper visitorRegisterMapper;

    @RequestMapping("/VisitorRegisterController")
    public Object doMain(HttpServletRequest request){
        String method = request.getParameter("method");
        if ("findAll".equals(method)){
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

    private Object update(HttpServletRequest request) {
        Integer visitorId = Integer.valueOf(request.getParameter("visitorId"));
        VisitorRegister visitorRegister = getVisitorRegister(request);
        visitorRegister.setVisitorId(visitorId);
        try {
            visitorRegisterMapper.update(visitorRegister);
            return "success";
        } catch (Exception e) {
            return "failure";
        }

    }

    private Object delete(HttpServletRequest request) {
        //获取来自请中所传递过来的序号字符串
        String visitorIdStr=request.getParameter("visitorIdStr");
        //将字符串进行按","(逗号)分割的子字符串数组
        String[] visitorIds=visitorIdStr.split(",");
        try {
            for (String visitorId : visitorIds) {
                visitorRegisterMapper.delete(visitorId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }

    }

    private Object add(HttpServletRequest request) {
        VisitorRegister visitorRegister = getVisitorRegister(request);
        try {
            visitorRegisterMapper.add(visitorRegister);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object findAll(HttpServletRequest request) {
        //得到来自请求中的条件数据
        String cometime=request.getParameter("cometime");
        String visitorName=request.getParameter("visitorName");
        String vistiAddress=request.getParameter("vistiAddress");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int num = (page-1)*rows;
        List<VisitorRegister> visitorRegisters =  visitorRegisterMapper.findAll(num,rows,cometime,visitorName,vistiAddress);
        int totals = visitorRegisterMapper.count(cometime,visitorName,vistiAddress);
        Map map = new HashMap<String,Object>();
        map.put("total",totals);
        map.put("rows",visitorRegisters);
        return map;
    }

    public VisitorRegister getVisitorRegister(HttpServletRequest request){
        String visitorName=request.getParameter("visitorName");
        String visitorGender = request.getParameter("visitorGender");
        String visitorIdNum=request.getParameter("visitorTelphone");
        String visitorTelphone=request.getParameter("visitorIdNum");
        String vistiAddress=request.getParameter("vistiAddress");
        String vistiReason=request.getParameter("vistiReason");
        String cometime=request.getParameter("cometime");
        String leaveTime=request.getParameter("leaveTime");
        String empNo=request.getParameter("empNo");
        //数据封装成对象
        VisitorRegister visitorRegister=new VisitorRegister(null,visitorName, visitorGender, visitorIdNum, visitorTelphone, vistiAddress, vistiReason, cometime, leaveTime, empNo);
        return visitorRegister;
    }

}
