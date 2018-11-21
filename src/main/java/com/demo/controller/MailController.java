package com.demo.controller;

import com.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MailController {
    @Autowired
    private MailService mailService;

    @RequestMapping("sendMail")
    @ResponseBody
    public  String sendMail(String to, String message, String title, @RequestParam("files") List<MultipartFile> files){
        if(files.get(0).getOriginalFilename().equals("")){
            mailService.sendSimpleMail(to, title, message);
        }else{
            File file = null;
            List<File> fileList = new ArrayList<>();
            for(MultipartFile file1:files){
                file = new File("F:/"+file1.getOriginalFilename());
                try {
                    file1.transferTo(file);
                    fileList.add(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            mailService.sendAttachmentsMail(to, title, message, fileList);
            for (File file2:fileList) {
                file2.delete();
            }
        }
        return "success";
    }

    @RequestMapping("getCheckCode")
    @ResponseBody
    public String getCheckCode(String email){
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为："+checkCode;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        }catch (Exception e){
            return "";
        }
        return checkCode;
    }
}
