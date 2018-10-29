package com.demo.bean;

import java.util.List;

/**
 * @ClassName: Dept
 * @Author: zhanghongkai
 * @Date: Create in 2018/9/7 16:47
 * @Version: 1.0
 */
public class Dept {
    private Integer id;
    private String name;
    private List<User> users;
    public Dept(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
