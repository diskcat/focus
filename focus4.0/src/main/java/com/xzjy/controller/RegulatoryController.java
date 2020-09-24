package com.xzjy.controller;

import com.xzjy.mapper.RegulatoryMapper;
import com.xzjy.pojo.Regulatory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

@RestController
public class RegulatoryController {
    @Autowired
    private RegulatoryMapper mapper;
    @RequestMapping("/RegulatoryController")
    public Object doMain(HttpServletRequest request){
        String method = request.getParameter("method");
        if ("findAll".equals(method)){
           return findAll(request);
        }else if("add".equals(method)){
            return this.add(request);
        }else if("update".equals(method)){
            return this.update(request);
        }else if("delete".equals(method)){
            return this.delete(request);
        }
        return null;
    }

    public String delete(HttpServletRequest request) {
        //获取来自请中所传递过来的序号字符串
        String fileIdStr=request.getParameter("fileIdStr");
        //将字符串进行按","(逗号)分割的子字符串数组
        String[] fileIds=fileIdStr.split(",");
        try {
            for (String fileId : fileIds) {
                mapper.deleteById(fileId);
            }
            return "success";
        }catch (Exception e){
            return "failure";
        }
    }

    public String update(HttpServletRequest request) {
        Regulatory regulatory = getRegulatory(request);
        try {
            mapper.update(regulatory);
            return "success";
        } catch (Exception e) {
            return "failure";
        }

        //数据封装成对象
    }

    public String add(HttpServletRequest request) {
        Regulatory regulatory = getRegulatory(request);
        try{
            mapper.add(regulatory);
            return "success";
        }catch (Exception e){
            return "failure";
        }
    }

    public HashMap findAll(HttpServletRequest request){
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int num = (page-1)*rows;
        String fileTheme = request.getParameter("fileTheme");
        String fileState = request.getParameter("fileState");
        List<Regulatory> regulatories = mapper.findByPage(num, rows,fileTheme,fileState);
        int total = mapper.count(fileTheme,fileState);
        HashMap map = new HashMap<String,Object>();
        map.put("rows",regulatories);
        map.put("total",total);
        return map;
    }


    public Regulatory getRegulatory(HttpServletRequest request){
        String fileId=request.getParameter("fileId");
        String fileTitle=request.getParameter("fileTitle");
        String fileTheme=request.getParameter("fileTheme");
        String fileState=request.getParameter("fileState");
        String executionTime=request.getParameter("executionTime");
        Regulatory regulatory=new Regulatory(fileId, fileTitle, fileTheme, fileState, executionTime);
        return regulatory;
    }

}
