package com.xzjy.controller;

import com.xzjy.mapper.ComplainMapper;
import com.xzjy.pojo.Complain;
import com.xzjy.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ComplainController {
    @Autowired
    private ComplainMapper complainMapper;
    private Users user = null;
    @RequestMapping("/ComplainController")
    public Object domain(HttpServletRequest request){
        String method=request.getParameter("method");
        if("findByName".equals(method)){
            return findByName(request);
        }else if("tousu".equals(method)){ //用户的投诉
            return toushu(request);
        }else if("deleteByIndex".equals(method)){
            int numb = Integer.parseInt(request.getParameter("numb"));
            complainMapper.deleteByIndex(numb,user.getUId());
        }else if("findAll".equals(method)){
            return findAll(request);
        }else if("add".equals(method)){
            return add(request);
        }else if ("delete".equals(method)){
            return delete(request);
        }else if("update".equals(method)){
            return update(request);
        }
        return null;
    }
    public Map findByName(HttpServletRequest request){
        HttpSession session = request.getSession();
        user = (Users) session.getAttribute("user");
        List<Complain> complains = complainMapper.findByName(user.getUId());
        Integer count = complainMapper.count(user.getUId());
        Map map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",complains);
        return map;
    }
    private Object update(HttpServletRequest request) {
        Integer comId = Integer.valueOf(request.getParameter("comId"));
        Complain complain = getComplain(request);
        complain.setComId(comId);
        try {
            complainMapper.update(complain);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object delete(HttpServletRequest request) {
        //获取来自请中所传递过来的投诉编号字符串
        String comStr=request.getParameter("comIdStr");
        //将字符串进行按","(逗号)分割的子字符串数组
        String[] comIds=comStr.split(",");
        try {
            for (String comId : comIds) {
                complainMapper.delete(comId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object add(HttpServletRequest request) {
        Complain complain = getComplain(request);
        try {
            complainMapper.add(complain);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object findAll(HttpServletRequest request) {
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int num = (page-1)*rows;
        //业主姓名
        String houseId=request.getParameter("houseId");
        //投诉内容
        String comText=request.getParameter("comText");
        //投诉时间
        String comTime=request.getParameter("comTime");
        List<Complain> complains = complainMapper.findAll(num,rows,houseId,comText,comTime);
        int totals = complainMapper.countAll(houseId,comText,comTime);
        Map map = new HashMap<String,Object>();
        map.put("total",totals);
        map.put("rows",complains);
        return map;
    }

    public Object toushu(HttpServletRequest request){
        String houseId=user.getUId();
        //投诉内容
        String comText=request.getParameter("comText");
        //获取当前系统时间
        Date date = new Date();
        //将系统时间转化为数据库格式
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //将时间转换成字符串格式
        String comTime=sdf.format(date);
        //默认员工
        String empName="陶小宁";
        //默认处理结果
        String comResult="未处理";
        //完成时间
        String comEndTime="2099-12-31";
        //数据封装成对象
        Complain complain=new Complain(null,houseId, comText, comTime, empName, comResult, comEndTime);
        complainMapper.add(complain);
        Map map = new HashMap<String,Object>();
        map.put("msg","success");
        return map;
    }

    public Complain getComplain(HttpServletRequest request){
        //业主姓名
        String houseId=request.getParameter("houseId");
        //投诉内容
        String comText=request.getParameter("comText");
        //投诉时间
        String comTime=request.getParameter("comTime");
        //受理人
        String empName=request.getParameter("empName");
        //处理结果
        String comResult=request.getParameter("comResult");
        //回访时间
        String comEndTime=request.getParameter("comEndTime");
        //数据封装成对象
        Complain complain=new Complain(null,houseId, comText, comTime, empName, comResult, comEndTime);
        return complain;
    }

}
