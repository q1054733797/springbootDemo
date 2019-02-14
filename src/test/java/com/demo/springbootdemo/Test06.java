package com.demo.springbootdemo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: Test06
 * @Author: zhanghongkai
 * @Date: Create in 2019/1/11 14:39
 * @Version: 1.0
 */
public class Test06 {
    public static void main(String[] args) {
        List<HashMap<String,String>> list = new ArrayList<>();
        HashMap<String,String> map1 = null;
        HashMap<String,String> map2 = new HashMap<>();
        map2.put("name", "张鸿凯");
        HashMap<String,String> map3 = new HashMap<>();
        HashMap<String,String> map4 = null;
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        System.out.println(list);
        list.clear();
        System.out.println(list);
    }
}
