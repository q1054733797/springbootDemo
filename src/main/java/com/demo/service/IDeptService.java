package com.demo.service;

import com.demo.bean.Dept;

import java.util.List;

/**
 * @ClassName: IDeptService
 * @Author: zhanghongkai
 * @Date: Create in 2018/9/7 17:06
 * @Version: 1.0
 */
public interface IDeptService {
    List<Dept> getDepts(String name);
    int addDept(Dept dept);
    int deleteDept(String ids);
    int updateDept(Dept dept);
}
