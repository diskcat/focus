package com.xzjy.controller;

import com.xzjy.mapper.LesseeInformationMapper;
import com.xzjy.pojo.LesseeInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LesseeInformationController {
    @Autowired
    private LesseeInformationMapper lesseeInformationMapper;

    @RequestMapping("/LesseeInformationController")
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
        Integer leaseContractId = Integer.valueOf(request.getParameter("leaseContractId"));
        LesseeInformation lesseeInformation = getLesseeInformation(request);
        lesseeInformation.setLeaseContractId(leaseContractId);
        try {
            lesseeInformationMapper.update(lesseeInformation);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object delete(HttpServletRequest request) {
        //接收来自网页数据
        String leaseContractIdStr = request.getParameter("leaseContractIdStr");
        //将字符串按"，"分割
        String[] leaseContractIdS = leaseContractIdStr.split(",");
        try {
            for (String leaseContractId : leaseContractIdS) {
                lesseeInformationMapper.delete(leaseContractId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object add(HttpServletRequest request) {
        LesseeInformation lesseeInformation = getLesseeInformation(request);
        try {
            lesseeInformationMapper.add(lesseeInformation);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object findAll(HttpServletRequest request) {
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int num = (page-1)*rows;
        String houseId = request.getParameter("houseId");
        String lesseeName = request.getParameter("lesseeName");
        if ("".equals(houseId)){
            houseId = null;
        }
        if ("".equals(lesseeName)){
            lesseeName = null;
        }
        List<LesseeInformation> lesseeInformations = lesseeInformationMapper.findAll(num,rows,houseId,lesseeName);
        int totals = lesseeInformationMapper.count(houseId,lesseeName);
        Map map = new HashMap<String,Object>();
        map.put("total",totals);
        map.put("rows",lesseeInformations);
        return map;
    }

    public LesseeInformation getLesseeInformation(HttpServletRequest request){
        String houseId = request.getParameter("houseId");
        String lesseeName = request.getParameter("lesseeName");
        String lesseeGender = request.getParameter("lesseeGender");
        String lesseeIdcard = request.getParameter("lesseeIdcard");
        String lesseeTelphone = request.getParameter("lesseeTelphone");
        String startTime = request.getParameter("startTime");
        String endTime =request.getParameter("endTime");
        LesseeInformation lesseeInformation = new LesseeInformation(null,houseId, lesseeName, lesseeGender, lesseeIdcard, lesseeTelphone, startTime, endTime);
        return lesseeInformation;
    }
}
