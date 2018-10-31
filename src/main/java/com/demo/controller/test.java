package com.demo.controller;

import com.demo.bean.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class test {
    @RequestMapping("test01")
    public String test01(Model model){
        Product product1 = new Product(1, "电脑", 1000);
        Product product2 = new Product(2, "电脑", 2000);
        Product product3 = new Product(3, "电脑", 3000);
        Product product4 = new Product(4, "电脑", 4000);
        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        String htmlContent = "<p style='color:red;'>红色文字</p>";
        model.addAttribute("product", product3);
        model.addAttribute("htmlContent", htmlContent);
        model.addAttribute("isOk", true);
        model.addAttribute("products", products);
        Date now = new Date();
        model.addAttribute("now", now);
        return "test01";
    }
}
