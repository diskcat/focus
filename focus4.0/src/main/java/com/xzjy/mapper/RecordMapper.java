package com.xzjy.mapper;

import com.xzjy.pojo.Rates;
import com.xzjy.pojo.Record;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RecordMapper {
    public List<Record> getRecordByName(String uId,int rows, int page);

    public int count(String uId);

    void add(Record record);

    void update(Record record);

    void delete(String recordId);

    List<Record> findAll(int nums, int rows, String recordId, String houseId, String recordType);

    int getTotals(String recordId, String houseId, String recordType);

    String total(String before, String after);

}
