package com.xzjy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    //添加视图解析器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/userLogin").setViewName("user/UsersLogin");
        registry.addViewController("/user/Regulatory").setViewName("user/Regulatory");
        registry.addViewController("/user/HouseInformation").setViewName("user/HouseInformation");
        registry.addViewController("/user/parkingInformation").setViewName("user/parkingInformation");
        registry.addViewController("/user/showMoney").setViewName("user/showMoney");
        registry.addViewController("/user/feeList").setViewName("user/feeList");
        registry.addViewController("/user/complain").setViewName("user/complain");
        registry.addViewController("/user/Rates").setViewName("user/Rates");
        registry.addViewController("/user/information").setViewName("user/information");
        //管理员系统
        registry.addViewController("/BackLogin").setViewName("admin/BackLogin");
        registry.addViewController("/Back/BackIndex").setViewName("admin/BackIndex");
        //公告管理模块
        registry.addViewController("/Back/RegulatoryCrud").setViewName("admin/RegulatoryCrud");
        //基础信息管理
        registry.addViewController("/Back/HouseInformationCrud").setViewName("admin/HouseInformationCrud");
        registry.addViewController("/Back/OwnerInformationCrud").setViewName("admin/OwnerInformationCrud");
        registry.addViewController("/Back/LesseeInformationCrud").setViewName("admin/LesseeInformationCrud");
        registry.addViewController("/Back/UserCrud").setViewName("admin/UserCrud");
        //日常管理
        registry.addViewController("/Back/VisitorRegister").setViewName("admin/VisitorRegister");
        registry.addViewController("/Back/ComplainCrud").setViewName("admin/ComplainCrud");
        //收费标准
        registry.addViewController("/Back/RatesCrud").setViewName("admin/RatesCrud");
        registry.addViewController("/Back/ArrearageCrud").setViewName("admin/ArrearageCrud");
        registry.addViewController("/Back/RecordCrud").setViewName("admin/RecordCrud");

    }
}
