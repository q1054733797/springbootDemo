package com.demo.controller;

import com.demo.bean.User;
import com.demo.service.IUserService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("register")
    @ResponseBody
    public String register(User user){
        Integer integer = userService.addUser(user);
        if(integer>0){
            return "ok";
        }else{
            return "false";
        }
    }

    @RequestMapping("getUsers")
    public @ResponseBody HashMap<String,Object> getUsers(String username){
        List users = userService.getUsers(username);
        HashMap<String,Object> map = new HashMap<>();
        map.put("resultList", users);
        return map;
    }

    @RequestMapping("addUser")
    public @ResponseBody String addUser(User user){
        Integer total = userService.addUser(user);
        if(total > 0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("deleteUser")
    public @ResponseBody String deleteUser(String ids){
        Integer total = userService.deleteUser(ids);
        if(total > 0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("updateUser")
    public @ResponseBody String updateUser(User user){
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getSex());
        System.out.println(user.getBirthday());
        System.out.println(user.getAddress());
        System.out.println(user.getDept().getName());
        Integer total = userService.updateUser(user);
        if(total > 0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping(value = "downloadFile",produces = "text/html;charset=UTF-8")
    public ResponseEntity<byte[]> downloadFile() throws IOException{
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        String filename = new String("下载测试.xls".getBytes("UTF-8"),"ISO8859-1");
        httpHeaders.setContentDispositionFormData("attachment", filename);
        return new ResponseEntity<>(FileUtils.readFileToByteArray(new File("C:\\Users\\zhanghongkai\\Desktop\\广西项目/PSBC-GX-电子设备管理系统项目计划20180824.xlsx")),httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value = "uploadFile",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String uploadFile(MultipartFile file) {
        System.out.println(file.getOriginalFilename());
        try {
            file.transferTo(new File("F:/"+file.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
}
