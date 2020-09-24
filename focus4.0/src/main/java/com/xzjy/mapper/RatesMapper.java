package com.xzjy.mapper;

import com.xzjy.pojo.Rates;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RatesMapper {
    public List<Rates> selectByPage(int rows, int page,String itemName);
    public int count(String itemName);

    void update(Rates rates);

    void delete(String itemId);

    void add(Rates rates);

    Rates getMoneyByHouseType(String houseType);
}
