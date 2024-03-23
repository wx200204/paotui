package com.example.newsb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.newsb.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM user WHERE account=#{account} And password=#{password}")
    User Login(User user);
    @Select("SELECT status FROM user WHERE userid=#{userid}")
    Integer selectstatus(int userid);
    @Insert("insert into user(account,password,status) values(#{account},#{password},0) ")
    Integer register(User user);





}
