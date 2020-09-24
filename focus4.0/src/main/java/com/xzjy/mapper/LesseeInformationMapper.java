package com.xzjy.mapper;

import com.xzjy.pojo.LesseeInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LesseeInformationMapper {
    void add(LesseeInformation lesseeInformation);;

    List<LesseeInformation> findAll(int num, int rows, String houseId, String lesseeName);

    void delete(String leaseContractId);

    void update(LesseeInformation lesseeInformation);

    int count(String houseId, String lesseeName);
}
