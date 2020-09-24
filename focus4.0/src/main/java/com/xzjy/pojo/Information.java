package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Information {
    private String backId;//后台登录账号
    private String backPwd;//密码
    private String empName;//姓名
    private String backPost;//职位
    private String tel;//职位
}
