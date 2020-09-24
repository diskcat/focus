package com.xzjy.mapper;

import com.xzjy.pojo.Arrearage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArrearageMapper {
    public Arrearage getArrearageByName(String uId);

    void update(Arrearage arrearage);

    void delete(String houseId);

    void add(Arrearage arrearage);

    List<Arrearage> findAll(int num, int rows, String houseId, String ownerName, String state);

    int count(String houseId, String ownerName, String state);

    double getMoney(String ownerName);

    List<Arrearage> getAllArrearage();
}
