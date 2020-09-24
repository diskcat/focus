package com.xzjy.mapper;

import com.xzjy.pojo.Complain;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ComplainMapper {

    public List<Complain> findByName(String houseId);

    public Integer count(String houseId);

    public void add(Complain complain);
    //numb对应的是第几页的数据
    public void deleteByIndex(int numb,String houseId);

    void update(Complain complain);

    void delete(String comId);

    List<Complain> findAll(int num, int rows, String houseId, String comText, String comTime);

    int countAll(String houseId, String comText, String comTime);
}
