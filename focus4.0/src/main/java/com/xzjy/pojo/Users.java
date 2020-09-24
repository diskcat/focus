package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users {
    private String uId; //用户编号
    private String uName;//用户名
    private String uPassword;	//用户密码
    private String uEmail; //用户邮箱
}
