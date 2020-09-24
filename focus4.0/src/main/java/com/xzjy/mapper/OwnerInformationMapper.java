package com.xzjy.mapper;

import com.xzjy.pojo.OwnerInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OwnerInformationMapper {
    void add(OwnerInformation ownerInformation);
    void deleteByHouseId(String houseId);

    List<OwnerInformation> findAll(int num, int rows, String ownerId, String houseId, String ownerName);

    int count(String ownerId, String houseId, String ownerName);

    void deleteByOwnerId(String ownerId);

    void update(OwnerInformation ownerInformation);
}
