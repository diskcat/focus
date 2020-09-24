package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Arrearage {
    //房屋编号
    private String houseId;
    //业主姓名
    private String ownerName;
    //业主手机号
    private String ownerTelphone;
    //状态
    private String state;
    //欠费金额
    private double arrearageMoney;
    //上次缴费时间
    private String arrearageDate;
}
