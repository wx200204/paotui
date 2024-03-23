package com.example.newsb.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.newsb.common.Result;
import com.example.newsb.entity.User;
import com.example.newsb.mapper.UserMapper;
import com.example.newsb.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
   public Result Login(User user){
       String newpassword= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
       QueryWrapper<User> qw = new QueryWrapper();

       // 2. 构造条件构造器
       // 第一个变量是书库据表中的字段，第二个变量是sql语句查询中要查找的值
       qw.eq("account", user.getAccount());
        qw.eq("password",newpassword);
try {
    User user1=userMapper.selectOne(qw);
    if(user1==null){
        return Result.error("333","账号或者密码错误");
    }

    return Result.ok().appenddata("info",user1,"token", TokenUtils.generateToken(user1.getUserid().toString()));
}catch (Exception e){
    return Result.fail();
}
    }

    public Integer findstatus( int userid){
 return userMapper.selectstatus(userid);
    }

    public Result Register(User user){

        try {
            String newpassword= DigestUtils.md5DigestAsHex(user.getPassword().getBytes());

            user.setPassword(newpassword);
            userMapper.register(user);
            return Result.ok().data("info","注册成功");
        }catch (Exception e){
            return Result.error("333","该账号已经被注册");
        }
    }



}
