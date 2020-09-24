package com.xzjy.controller;

import com.xzjy.mapper.InformationMapper;
import com.xzjy.pojo.Information;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class InformationController {
    @Autowired
    private InformationMapper informationMapper;

    @RequestMapping("/findAllInformation")
    public Object findAllInformation(){
        List<Information> informations = informationMapper.findAll();
        int totals = informationMapper.count();
        Map map = new HashMap<String,Object>();
        map.put("rows",informations);
        map.put("total",totals);
        return map;
    }

}
