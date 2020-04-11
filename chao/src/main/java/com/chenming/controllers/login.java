package com.chenming.controllers;

import com.chenming.dao.userMapper;
import com.chenming.pojo.User;
import com.chenming.services.userService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class login {
    @Autowired
    private userService service;

    @RequestMapping("/login")
    @ResponseBody
    public String login(User u, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        return service.login(u,request,response);
    }
    @RequestMapping("/signIn")
    @ResponseBody
    public String signIn(User u){
        return service.signIn(u);
    }
}
