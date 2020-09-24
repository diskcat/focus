package com.xzjy.mapper;

import com.xzjy.pojo.HouseInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface HouseInformationMapper {
    public HouseInformation getHouseInformationByName(String uId);

    List<HouseInformation> findAll(int page, int rows,  String houseId, String ownerName,
                                   String houseType,String houseNature, String houseState);

    int count(String houseId, String ownerName, String houseType, String houseNature, String houseState);

    void add(HouseInformation houseInformation);

    void delete(String houseId);

    int update(HouseInformation houseInformation);
}
