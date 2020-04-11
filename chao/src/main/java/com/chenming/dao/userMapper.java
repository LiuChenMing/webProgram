package com.chenming.dao;

import com.chenming.pojo.User;

public interface userMapper {
    public User getUserById(String userId);
    public int addUser(User user);
    public int update(User user);
}
