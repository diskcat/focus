package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HouseInformation {
    //房屋编号
    private String houseId;
    //户主姓名
    private String ownerName;
    //房屋类型
    private String houseType;
    //面积
    private double houseArea;
    //房屋性质
    private String houseNature;
    //房屋状态
    private String houseState;
    //地址
    private String houseAddress;
}
