package com.xzjy.controller;

import com.xzjy.mapper.HouseInformationMapper;
import com.xzjy.mapper.LesseeInformationMapper;
import com.xzjy.mapper.OwnerInformationMapper;
import com.xzjy.pojo.HouseInformation;
import com.xzjy.pojo.LesseeInformation;
import com.xzjy.pojo.OwnerInformation;
import com.xzjy.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class HouseInformationController {

    @Autowired
    private HouseInformationMapper houseInformationMapper;
    @Autowired
    private OwnerInformationMapper ownerInformationMapper;
    @Autowired
    private LesseeInformationMapper lesseeInformationMapper;
    //手动事务
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;

    @RequestMapping("/HouseInformationController")
    public Object doMain(HttpServletRequest request, HttpSession session){
        String method = request.getParameter("method");
        if ("findByName".equals(method)){
            Users user = (Users) session.getAttribute("user");
            HouseInformation houseInformation = houseInformationMapper.getHouseInformationByName(user.getUId());
            return houseInformation;
        }else if("findAll".equals(method)){
            return findAll(request);
        }else if("add".equals(method)){
            return add(request);
        }else if("delete".equals(method)){
            return delete(request);
        }else if("update".equals(method)){
            return update(request);
        }else if("alteration".equals(method)){
            return alteration(request);
        }else if("lease".equals(method)){
            return lease(request);
        }
        return null;
    }

    private Object lease(HttpServletRequest request) {
        HouseInformation houseInformation = getHouseInformation(request);
        LesseeInformation lesseeInformation = getLesseeInformation(request);
        houseInformation.setHouseState("出租");
        houseInformation.setOwnerName(lesseeInformation.getLesseeName());
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            houseInformationMapper.update(houseInformation);
            lesseeInformationMapper.add(lesseeInformation);
            dataSourceTransactionManager.commit(transactionStatus);
            return "success";
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            return "failure";
        }
    }

    public String alteration(HttpServletRequest request) {
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            HouseInformation houseInformation = getHouseInformation(request);
            houseInformation.setHouseState("已售");
            houseInformationMapper.update(houseInformation);
            OwnerInformation ownerInformation = getOwnerInformation(request);
            ownerInformationMapper.deleteByHouseId(ownerInformation.getHouseId());
            ownerInformationMapper.add(ownerInformation);
            dataSourceTransactionManager.commit(transactionStatus);
            return "success";
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            return "failure";
        }
    }

    private Object update(HttpServletRequest request) {
        HouseInformation houseInformation = getHouseInformation(request);
        try {
            houseInformationMapper.update(houseInformation);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Object delete(HttpServletRequest request) {
        String houseIdStr = request.getParameter("houseIdStr");
        String[] houseIdS = houseIdStr.split(",");
        try {
            for (String houseId : houseIdS) {
                houseInformationMapper.delete(houseId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }

    }

    private Object add(HttpServletRequest request) {
        HouseInformation houseInformation = getHouseInformation(request);
        try {
            houseInformationMapper.add(houseInformation);
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
        String ownerName = request.getParameter("ownerName");
        String houseType = request.getParameter("houseType");
        String houseNature = request.getParameter("houseNature");
        String houseState = request.getParameter("houseState");
        //解决不显示null的bug设置""为null
        if("".equals(houseId)){
            houseId = null;
        }
        if("".equals(ownerName)){
            ownerName = null;
        }
        if("".equals(houseType)){
            houseType = null;
        }
        if("".equals(houseNature)){
            houseNature = null;
        }
        if("".equals(houseState)){
            houseState = null;
        }
        List<HouseInformation> list = houseInformationMapper.findAll(num,rows,houseId,ownerName,houseType,houseNature,houseState);
        int rowsTotal = houseInformationMapper.count(houseId,ownerName,houseType,houseNature,houseState);
        Map map = new HashMap<String,Object>();
        map.put("total",rowsTotal);
        map.put("rows",list);
        return map;
    }



    public HouseInformation getHouseInformation(HttpServletRequest request){
        String houseId = request.getParameter("houseId");
        String ownerName = request.getParameter("ownerName");
        String houseType = request.getParameter("houseType");
        double houseArea = Double.parseDouble(request.getParameter("houseArea"));
        String houseNature = request.getParameter("houseNature");
        String houseState = request.getParameter("houseState");
        String houseAddress = request.getParameter("houseAddress");
        HouseInformation houseInformation = new HouseInformation(houseId, ownerName, houseType, houseArea, houseNature, houseState, houseAddress);
        return houseInformation;
    }

    public OwnerInformation getOwnerInformation(HttpServletRequest request){
        String houseId = request.getParameter("houseId");
        String ownerName = request.getParameter("ownerName");
//        String ownerId = request.getParameter("ownerId");
        //mysql设置了触发器,增加用户体验删除html输入框
        String ownerId = null;
        String ownerSex = request.getParameter("ownerSex");
        String ownerIdcard = request.getParameter("ownerIdcard");
        String ownerTelphone = request.getParameter("ownerTelphone");
        String ownerEmail = request.getParameter("ownerEmail");
        String ownerAddress = request.getParameter("ownerAddress");
        //创建房屋对象保存数据
        OwnerInformation ownerInformation = new OwnerInformation(ownerId, houseId, ownerName, ownerSex, ownerIdcard, ownerTelphone, ownerEmail, ownerAddress);
        return ownerInformation;
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
