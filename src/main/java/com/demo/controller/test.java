package com.demo.controller;

import com.demo.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class test {
    @RequestMapping("test01")
    public String test01(){
        return "test01";
    }

    @RequestMapping("test02")
    @ResponseBody
    public User test02(@RequestBody User user){
        return user;
    }
}
