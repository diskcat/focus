package com.xzjy.mapper;

import com.xzjy.pojo.Information;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InformationMapper {
    //实现管理员登录功能

    List<Information> findAll();

    int count();

    Information login(String backId);
}
