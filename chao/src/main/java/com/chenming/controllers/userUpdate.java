package com.chenming.controllers;

import com.chenming.dao.userMapper;
import com.chenming.pojo.User;
import com.chenming.services.userService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

@RequestMapping("/user")
public class userUpdate {

    @Autowired
    userService service;

    @ResponseBody
    @RequestMapping("/userUpdate")
    public String update(@NotNull User u){
        System.out.println(u);
       return service.update(u);
    }
}
