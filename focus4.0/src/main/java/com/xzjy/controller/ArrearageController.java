package com.xzjy.controller;
import com.xzjy.mapper.ArrearageMapper;
import com.xzjy.mapper.HouseInformationMapper;
import com.xzjy.mapper.RatesMapper;
import com.xzjy.mapper.RecordMapper;
import com.xzjy.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
public class ArrearageController {
    //手动事务
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;
    @Autowired
    private TransactionDefinition transactionDefinition;
    @Autowired
    private ArrearageMapper arrearageMapper;
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private RatesMapper ratesMapper; //为了得到单价
    @Autowired
    private HouseInformationMapper houseInformationMapper; //获得房屋的大小类型

    @RequestMapping("/ArrearageController")
    public Object doMain(HttpServletRequest request, HttpSession session){
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
        }else if("jiaofei".equals(method)){
            return jiaofei(request);
        }else if("qianfei".equals(method)){
            return calculateArrearageMoney();
        }
        return  null;
    }

    private String jiaofei(HttpServletRequest request) {
        Arrearage arrearage = getArrearage(request);
        double money = arrearageMapper.getMoney(arrearage.getOwnerName());
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);
        try {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String format = sdf.format(date);
            arrearage.setArrearageDate(format);
            arrearageMapper.update(arrearage);
            if(money-arrearage.getArrearageMoney()>0){
                Record record = new Record(null,arrearage.getHouseId(),arrearage.getOwnerTelphone(),
                        "物业费",money-arrearage.getArrearageMoney(),format);
                recordMapper.add(record);
            }
            dataSourceTransactionManager.commit(transactionStatus);
            return "success";
        } catch (Exception e) {
            dataSourceTransactionManager.rollback(transactionStatus);
            return "failure";
        }
    }

    private String update(HttpServletRequest request) {
        Arrearage arrearage = getArrearage(request);
        try {
            arrearageMapper.update(arrearage);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private String delete(HttpServletRequest request) {
        //接收来自网页数据
        String houseIdStr = request.getParameter("houseIdStr");
        //将字符串按"，"分割
        String[] houseIdS = houseIdStr.split(",");
        try {
            for (String houseId : houseIdS) {
                arrearageMapper.delete(houseId);
            }
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private String add(HttpServletRequest request) {
        Arrearage arrearage = getArrearage(request);
        try {
            arrearageMapper.add(arrearage);
            return "success";
        } catch (Exception e) {
            return "failure";
        }
    }

    private Map findAll(HttpServletRequest request) {
        int rows = Integer.parseInt(request.getParameter("rows"));
        int page = Integer.parseInt(request.getParameter("page"));
        int num = (page-1)*rows;
        String houseId = request.getParameter("houseId");
        String ownerName = request.getParameter("ownerName");
        String state = request.getParameter("state");
        List<Arrearage> arrearages = arrearageMapper.findAll(num,rows,houseId,ownerName,state);
        int totals = arrearageMapper.count(houseId,ownerName,state);
        Map map = new HashMap<String,Object>();
        map.put("total",totals);
        map.put("rows",arrearages);
        return map ;
    }

    private Map findByName(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Users users=(Users)session.getAttribute("user");
        Arrearage arrearage = arrearageMapper.getArrearageByName(users.getUId());
        Map map = new HashMap<String,Object>();
        map.put("msg",arrearage);
        return map;
    }

    public Arrearage getArrearage(HttpServletRequest request){
        String houseId = request.getParameter("houseId");
        String ownerName = request.getParameter("ownerName");
        String ownerTelphone = request.getParameter("ownerTelphone");
        String state = request.getParameter("state");
        double arrearageMoney = Double.parseDouble(request.getParameter("arrearageMoney"));
        String arrearageDate = request.getParameter("arrearageDate");
        Arrearage arrearage = new Arrearage(houseId, ownerName, ownerTelphone, state, arrearageMoney, arrearageDate);
        return arrearage;
    }

    //计算物业费
    public String calculateArrearageMoney(){
        TransactionStatus transactionStatus = dataSourceTransactionManager.getTransaction(transactionDefinition);//开启事务
        Rates rates = null;
        List<Arrearage> arrearages = arrearageMapper.getAllArrearage();
        try {
            for (Arrearage arrearage : arrearages) {
                //根据房屋编号知道房屋的性质
                HouseInformation houseInformation = houseInformationMapper.getHouseInformationByName(arrearage.getHouseId());
                String houseType = houseInformation.getHouseType();
                double houseArea = houseInformation.getHouseArea();
                if (!"商铺".equals(houseType)){ //不是商铺计算价格
                    //获取住宅物业费
                    rates = ratesMapper.getMoneyByHouseType("住宅");
                }else{
                    rates = ratesMapper.getMoneyByHouseType("商铺");
                }
                //计算天数
                Date now = new Date();
                String arrearageDate = arrearage.getArrearageDate();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Date ago = sdf.parse(arrearageDate);
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(now);
                long nowMillis = calendar.getTimeInMillis();
                calendar.setTime(ago);
                long agoMillis = calendar.getTimeInMillis();
                Long betweenDate = (nowMillis - agoMillis)/(1000L*3600L*24L); //计算出来的天数
                Double dayPrice = rates.getRatesMoney(); //每平方米单价
                Double arrearageMoney = betweenDate*dayPrice*houseArea; //获取欠款信息
                Double money = arrearage.getArrearageMoney() + arrearageMoney; //欠款的总金额
                if(money!=0){
                    arrearage.setState("欠费");
                }else{
                    arrearage.setState("已交清");
                }
                //更新数据
                String nowTime = sdf.format(now);
                Arrearage newArrearage = new Arrearage(arrearage.getHouseId(),arrearage.getOwnerName(),
                        arrearage.getOwnerTelphone(),arrearage.getState(),money,nowTime);
                arrearageMapper.update(newArrearage);
            }
            dataSourceTransactionManager.commit(transactionStatus);
        } catch (Exception e) {
            dataSourceTransactionManager.commit(transactionStatus);
            return "failure";
        }
        return "success";
    }
}
