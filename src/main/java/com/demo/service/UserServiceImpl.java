package com.demo.service;

import com.demo.bean.User;
import com.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer deleteUser(String ids) {
        return userMapper.deleteUser(ids);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public List<User> getUsers(String username) {
        return userMapper.getUsers(username);
    }

    @Override
    public Integer addUsrByXml(User user) {
        return userMapper.addUserByXml(user);
    }
}
