package com.xzjy.controller;

import com.xzjy.mapper.OwnerInformationMapper;
import com.xzjy.pojo.OwnerInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OwnerInformationController {
    @Autowired
    private OwnerInformationMapper ownerInformationMapper;

    @RequestMapping("/OwnerInformationController")
    public Object doMain(HttpServletRequest request){
        String method = request.getParameter("method");
        if("findAll".equals(method)){
            return findAll(request);
        }else if("add".equals(method)){
            return add(request);
        }else if("delete".equals(method)){
            return delete(request);
        }else if ("update".equals(method)){
            return update(request);
        }
        return null;
    }

    private Object update(HttpServletRequest request) {
        OwnerInformation ownerInformation = getOwnerInformation(request);
        try {
            ownerInformationMapper.update(ownerInformation);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object delete(HttpServletRequest request) {
        //接收来自网页数据
        String ownerIdStr = request.getParameter("ownerIdStr");
        //将字符串按"，"分割
        String[] ownerIdS = ownerIdStr.split(",");
        try {
            for (String ownerId : ownerIdS) {
                ownerInformationMapper.deleteByOwnerId(ownerId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object add(HttpServletRequest request) {
        OwnerInformation ownerInformation = getOwnerInformation(request);
        System.out.println(ownerInformation);
        try {
            //设置了触发器提升用户体验
            ownerInformation.setOwnerId(null);
            System.out.println(ownerInformation);
            ownerInformationMapper.add(ownerInformation);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object findAll(HttpServletRequest request) {
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int num = (page-1)*rows;
        String ownerId = request.getParameter("ownerId");
        String houseId = request.getParameter("houseId");
        String ownerName = request.getParameter("ownerName");
        if ("".equals(ownerId)){
            ownerId = null;
        }
        if("".equals(houseId)){
            houseId = null;
        }
        if("".equals(ownerName)){
            ownerName = null;
        }
        List<OwnerInformation> ownerInformationList = ownerInformationMapper.findAll(num,rows,ownerId,houseId,ownerName);
        int totals = ownerInformationMapper.count(ownerId,houseId,ownerName);
        Map map = new HashMap<String,Object>();
        map.put("total",totals);
        map.put("rows",ownerInformationList);
        return map;
    }

    public OwnerInformation getOwnerInformation(HttpServletRequest request){
        String houseId = request.getParameter("houseId");
        String ownerName = request.getParameter("ownerName");
        String ownerId = request.getParameter("ownerId");
        //mysql设置了触发器,增加用户体验删除html输入框
//        String ownerId = null;
        String ownerSex = request.getParameter("ownerSex");
        String ownerIdcard = request.getParameter("ownerIdcard");
        String ownerTelphone = request.getParameter("ownerTelphone");
        String ownerEmail = request.getParameter("ownerEmail");
        String ownerAddress = request.getParameter("ownerAddress");
        //创建房屋对象保存数据
        OwnerInformation ownerInformation = new OwnerInformation(ownerId, houseId, ownerName, ownerSex, ownerIdcard, ownerTelphone, ownerEmail, ownerAddress);
        return ownerInformation;
    }
}
