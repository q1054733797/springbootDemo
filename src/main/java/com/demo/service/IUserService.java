package com.demo.service;

import com.demo.bean.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers(String username);
    Integer addUser(User user);
    Integer deleteUser(String ids);
    Integer updateUser(User user);
}
