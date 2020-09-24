package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

//业主信息表
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OwnerInformation {
    //业主编号
    private String ownerId;
    //房屋编号
    private String houseId;
    //业主姓名
    private String ownerName;
    //性别
    private String ownerSex;
    //身份证号码
    private String ownerIdcard;
    //电话号码
    private String ownerTelphone;
    //邮箱
    private String ownerEmail;
    //邮寄地址
    private String ownerAddress;

}
