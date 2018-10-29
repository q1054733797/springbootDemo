package com.demo.controller;

import com.demo.bean.Dept;
import com.demo.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: DeptController
 * @Author: zhanghongkai
 * @Date: Create in 2018/9/10 14:44
 * @Version: 1.0
 */
@Controller
public class DeptController {
    @Autowired
    private IDeptService deptService;

    @RequestMapping("getDepts")
    public @ResponseBody HashMap<String,Object> getDepts(String name,int pageIndex, int pageSize){
        List<Dept> depts = deptService.getDepts(name);
        int total = depts.size();
        depts = depts.subList(pageIndex*pageSize, (pageIndex*pageSize+pageSize)>total? total:(pageIndex*pageSize+pageSize));
        HashMap<String,Object> map = new HashMap<>();
        map.put("resultList", depts);
        map.put("total", total);
        return map;
    }

    @RequestMapping("addDept")
    public @ResponseBody String addDept(Dept dept){
        int i = deptService.addDept(dept);
        if(i>0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("deleteDept")
    public @ResponseBody String deleteDept(String ids){
        int i = deptService.deleteDept(ids);
        if(i>0){
            return "success";
        }else{
            return "false";
        }
    }

    @RequestMapping("updateDept")
    public @ResponseBody String updateDept(Dept dept){
        int i = deptService.updateDept(dept);
        if(i>0){
            return "success";
        }else{
            return "false";
        }
    }
}
