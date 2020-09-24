package com.xzjy.mapper;

import com.xzjy.pojo.VisitorRegister;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface VisitorRegisterMapper {

    void update(VisitorRegister visitorRegister);

    void delete(String visitorId);

    void add(VisitorRegister visitorRegister);

    List<VisitorRegister> findAll(int num, int rows, String cometime,String visitorName,String vistiAddress);

    int count(String cometime,String visitorName,String vistiAddress);
}
