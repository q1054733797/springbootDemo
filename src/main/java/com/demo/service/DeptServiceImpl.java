package com.demo.service;

import com.demo.bean.Dept;
import com.demo.mapper.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName: DeptServiceImpl
 * @Author: zhanghongkai
 * @Date: Create in 2018/9/7 17:07
 * @Version: 1.0
 */

@Service("deptService")
@Transactional
public class DeptServiceImpl implements IDeptService{
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getDepts(String name) {
        return deptMapper.getDepts(name);
    }

    @Override
    public int addDept(Dept dept) {
        return deptMapper.addDept(dept);
    }

    @Override
    public int deleteDept(String ids) {
        return deptMapper.deleteDept(ids);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }
}
