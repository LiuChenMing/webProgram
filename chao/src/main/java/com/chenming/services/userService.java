package com.chenming.services;

import com.chenming.dao.userMapper;
import com.chenming.pojo.User;
import com.chenming.pojo.loginInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class userService {
    @Autowired
    userMapper usermapper;

    public String update(@NotNull User u){
        System.out.println(u);
        if(usermapper.getUserById(u.getUserId())==null)
            return "false";
        else{
            if(usermapper.update(u)==0)
                return "false";
            return "true";
        }
    }
    public String login(User u, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        loginInfo info=new loginInfo();
        ObjectMapper mapper=new ObjectMapper();
        if(u==null)
            info.setStatus("error");
        User su=usermapper.getUserById(u.getUserId());
        if(su==null||!u.getPassword().equals(su.getPassword())){
            info.setStatus("error");
        }else{
            info.setStatus("success");

            //把密码屏蔽，再返回给客户端
            su.setPassword(null);

            info.setUserInfo(su);
            //创建含有userId的cookie，用于登录状态验证
            Cookie cookie=new Cookie("userId",u.getUserId());
            cookie.setMaxAge(2*60*60);
            cookie.setPath("/chao");
            response.addCookie(cookie);

        }

        return mapper.writeValueAsString(info);
    }

    public String signIn(User u){
        if(usermapper.addUser(u)==0)
            return "error";
        return "success";
    }
}
