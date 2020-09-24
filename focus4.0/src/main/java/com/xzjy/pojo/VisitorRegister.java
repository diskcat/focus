package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorRegister {
    private Integer visitorId;//来访编号
    private String visitorName;//姓名
    private String visitorGender;//性别
    private String visitorIdNum;//身份证号
    private String visitorTelphone;//电话
    private String vistiAddress;//到访地点
    private String vistiReason;//到访事由
    private String cometime;//登记时间
    private String leaveTime;//离开时间
    private String empNo;//值班员
}
