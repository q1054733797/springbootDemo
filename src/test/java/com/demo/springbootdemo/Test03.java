package com.demo.springbootdemo;

import com.demo.bean.User;
import com.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @ClassName: Test03
 * @Author: zhanghongkai
 * @Date: Create in 2018/11/29 15:05
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test03 {
    @Autowired
    private IUserService userService;

    @Test
    public void test03(){
        User user = new User();
        user.setUsername("test01");
        user.setPassword("123456");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setAddress("山西阳泉");
        userService.addUser(user);
        System.out.println(user.getId());
    }
}
