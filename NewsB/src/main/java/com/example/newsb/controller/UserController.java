package com.example.newsb.controller;

import com.example.newsb.common.Result;
import com.example.newsb.entity.User;
import com.example.newsb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public Result Login(User user){

            return userService.Login(user);


    }
    @GetMapping("/register")
    public Result Register(User user){

        return userService.Register(user);


    }

}
