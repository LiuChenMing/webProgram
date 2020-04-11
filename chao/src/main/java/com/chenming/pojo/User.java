package com.chenming.pojo;

public class User {
    private String userId;
    private String password;

    private String email;
    private String address;
    private String nickname;
    private String gender;
    private Integer age;
    private String alipayId;

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", nickname='" + nickname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", alipayId='" + alipayId + '\'' +
                '}';
    }

    public User(String userId, String password, String email, String address, String nickname, String gender, Integer age, String alipayId) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.address = address;
        this.nickname = nickname;
        this.gender = gender;
        this.age = age;
        this.alipayId = alipayId;
    }

    public User(){}


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAlipayId() {
        return alipayId;
    }

    public void setAlipayId(String alipayId) {
        this.alipayId = alipayId;
    }
}
