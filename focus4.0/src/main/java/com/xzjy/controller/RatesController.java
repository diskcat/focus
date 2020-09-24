package com.xzjy.controller;

import com.xzjy.mapper.RatesMapper;
import com.xzjy.pojo.Rates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RatesController {
    @Autowired
    private RatesMapper ratesMapper;
    @RequestMapping("/RatesController")
    public Object findAll(HttpServletRequest request, HttpSession session){
        String method=request.getParameter("method");
        if("findAll".equals(method)){
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

    private String update(HttpServletRequest request) {
        Integer itemId = Integer.valueOf(request.getParameter("itemId"));
        Rates rates = getRates(request);
        rates.setItemId(itemId);
        try {
            ratesMapper.update(rates);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private String delete(HttpServletRequest request) {
        //接收来自网页数据
        String itemIdStr = request.getParameter("itemIdStr");
        //将字符串进行按","(逗号)分割的子字符串数组
        String[] itemIdS = itemIdStr.split(",");
        try {
            for (String itemId : itemIdS) {
                ratesMapper.delete(itemId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private String add(HttpServletRequest request) {
        Rates rates = getRates(request);
        try {
            ratesMapper.add(rates);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    public Map findAll(HttpServletRequest request){
        String itemName = request.getParameter("itemName");
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int nums = (page-1)*rows;
        List<Rates> rates = ratesMapper.selectByPage(rows, nums,itemName);
        int count = ratesMapper.count(itemName);
        Map map = new HashMap<String,Object>();
        map.put("total",count);
        map.put("rows",rates);
        return map;
    }

    public Rates getRates(HttpServletRequest request){
        String itemName = request.getParameter("itemName");
        String itemDesc = request.getParameter("itemDesc");
        double ratesMoney = Double.parseDouble(request.getParameter("ratesMoney"));
        Rates rates = new Rates(null,itemName,itemDesc,ratesMoney);
        return rates;
    }

}
