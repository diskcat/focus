package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LesseeInformation {
    //编号
    private Integer leaseContractId;
    //房号
    private String houseId;
    //租户姓名
    private String lesseeName;
    //租户性别
    private String lesseeGender;
    //身份证号
    private String lesseeIdcard;
    //电话
    private String lesseeTelphone;
    //起租时间
    private String startTime;
    //退租时间
    private String endTime;
}
