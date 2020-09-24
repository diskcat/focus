package com.xzjy.controller;

import com.xzjy.mapper.RecordMapper;
import com.xzjy.pojo.Record;
import com.xzjy.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RecordController {

    @Autowired
    private RecordMapper recordMappermapper;
    @RequestMapping("/RecordController")
    public Object doMian(HttpServletRequest request, HttpSession session){
        String method = request.getParameter("method");
        if(method.equals("findByName")){
            return findByName(request);
        }else if(method.equals("findAll")){
            return findAll(request);
        }else if("add".equals(method)){
            return add(request);
        }else if("delete".equals(method)){
            return delete(request);
        }else if("update".equals(method)){
            return update(request);
        }else if("total".equals(method)){
            return total(request);
        }
        return null;
    }

    private Map total(HttpServletRequest request) {
        String before = request.getParameter("recordDateBefore");
        String after = request.getParameter("recordDateAfter");
        Map map = new HashMap<String,Object>();
        try {
            String money = recordMappermapper.total(before,after);
            map.put("money",money);
            map.put("msg","success");
        } catch (Exception e) {
            map.put("msg","failure");
        }
        return map;
    }

    private String add(HttpServletRequest request) {
        Record record = getRecord(request);
        try {
            recordMappermapper.add(record);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private String update(HttpServletRequest request) {
        Record record = getRecord(request);
        try {
            recordMappermapper.update(record);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private String delete(HttpServletRequest request) {
        //接收来自网页数据
        String recordIdStr = request.getParameter("recordIdStr");
        //将字符串按"，"分割
        String[] recordIdS = recordIdStr.split(",");
        try {
            for (String recordId : recordIdS) {
                recordMappermapper.delete(recordId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Map findAll(HttpServletRequest request) {
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int nums = (page-1)*rows;
        String recordId = request.getParameter("recordId");
        String houseId = request.getParameter("houseId");
        String recordType = request.getParameter("recordType");
        List<Record> records = recordMappermapper.findAll(nums,rows,recordId,houseId,recordType);
        int totals = recordMappermapper.getTotals(recordId,houseId,recordType);
        Map map = new HashMap<String,Object>();
        map.put("total",totals);
        map.put("rows",records);
        return map;
    }

    private Map findByName(HttpServletRequest request) {
        int rows = 10;
        int page = 1;
        if(!StringUtils.isEmpty(request.getParameter("rows"))){
            rows = Integer.parseInt(request.getParameter("rows"));
        }
        if(!StringUtils.isEmpty(request.getParameter("page"))){
            page = Integer.parseInt(request.getParameter("page"));
        }

        int nums = (page-1)*rows;
        HttpSession session = request.getSession();
        Users user=(Users) session.getAttribute("user");
        List<Record> records = recordMappermapper.getRecordByName(user.getUId(),rows,nums);
        int count = recordMappermapper.count(user.getUId());
        Map map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",records);
        return map;
    }

    public Record getRecord(HttpServletRequest request){
        String str_recordId = request.getParameter("recordId");
        Integer recordId = null;
        if(!StringUtils.isEmpty(str_recordId)){
            recordId = Integer.parseInt(str_recordId);
        }
        String houseId = request.getParameter("houseId");
        String ownerTelphone = request.getParameter("ownerTelphone");
        String recordType = request.getParameter("recordType");
        double recordMoney = Double.parseDouble(request.getParameter("recordMoney"));
        String recordDate = request.getParameter("recordDate");
        Record record = new Record(recordId, houseId, ownerTelphone, recordType, recordMoney, recordDate);
        return record;
    }
}
