package com.example.newsb.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("user")
public class User {
    @TableId
    private Integer userid;
    private String account;
    private String password;
    private Integer status;
    private String nickname;
    private String upic;


}
