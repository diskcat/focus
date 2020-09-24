package com.xzjy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Regulatory {
    private String fileId;//公告编号

    private String fileTitle;//标题

    private String fileTheme;//主题

    private String fileState;//状态

    private String executionTime;//执行时间
}
