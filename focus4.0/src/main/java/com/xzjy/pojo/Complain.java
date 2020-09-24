package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Complain {
    private Integer comId;//受理编号
    private String houseId;//投诉人(业主姓名)
    private String comText;//投诉内容
    private String comTime;//投诉时间
    private String empName;//受理人（客服部门人员）
    private String comResult;//处理结果
    private String comEndTime;//完成时间
}
