package com.chenming.pojo;

public class loginInfo {
    private String status;
    private User userInfo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(User userInfo) {
        this.userInfo = userInfo;
    }

    public loginInfo(String status, User userInfo) {
        this.status = status;
        this.userInfo = userInfo;
    }
    public loginInfo(){}
}
