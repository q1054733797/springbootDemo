package com.demo.springbootdemo;

import com.demo.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: Test05
 * @Author: zhanghongkai
 * @Date: Create in 2018/12/18 9:56
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test05 {
    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        List users = userService.getUsers("");
        System.out.println(users);
        HashMap map = null;
        for (Object user : users) {
            map = (HashMap)user;
            if(map.get("sex").equals("1")){
                map.put("sex", "男");
            }else if(map.get("sex").equals("2")){
                map.put("sex", "女");
            }
        }
        System.out.println(users);
    }
}
