package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rates {
    //收费标准表
    private Integer itemId;
    private String itemName;
    private String itemDesc;
    private double ratesMoney;

}
