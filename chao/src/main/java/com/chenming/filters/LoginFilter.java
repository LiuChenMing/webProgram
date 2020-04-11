package com.chenming.filters;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uri=req.getRequestURI();


        //判断请求是否要求登录
        boolean isNeedLogin=uri.contains("/user/");


        boolean isLogin=false;
        if(req.getCookies()!=null){
            for (Cookie cookie :
                    req.getCookies()) {
                if (cookie.getName().equals("userId"))
                    isLogin=true;
            }
        }
        //请求需要登录的资源，但未登录的，重定向至登录页面
        if(isNeedLogin&&!isLogin){
            res.sendRedirect("/chao/pages/login.html");
        }else{
            filterChain.doFilter(req,res);
        }
    }

    @Override
    public void destroy() {

    }
}
