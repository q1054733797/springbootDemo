package com.demo.controller;

import com.demo.bean.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @RequestMapping("/test")
    public void index(User user){
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getDept().getName());
    }
}
