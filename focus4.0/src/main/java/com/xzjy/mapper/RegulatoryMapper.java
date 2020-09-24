package com.xzjy.mapper;

import com.xzjy.pojo.Regulatory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface RegulatoryMapper {
    public List<Regulatory> findByPage(int page, int rows,String fileTheme,String fileState);

    void deleteById(String fileId);

    void update(Regulatory regulatory);

    void add(Regulatory regulatory);

    int count(String fileTheme, String fileState);
}
