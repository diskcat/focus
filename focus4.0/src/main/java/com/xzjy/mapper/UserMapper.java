package com.xzjy.mapper;

import com.xzjy.pojo.Users;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {

    public Users login(String uId);

    List<Users> findAll(int num, int rows, String uId, String uName);

    int count(String uId, String uName);

    void update(Users users);

    void add(Users users);

    void delete(String uId);
}
