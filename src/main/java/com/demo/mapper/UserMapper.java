package com.demo.mapper;

import com.demo.bean.Dept;
import com.demo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface UserMapper {
    /* 根据用户名查找用户 */
    @Select("select * from user where username like '%${value}%'")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "dept",column = "id",one = @One(
                    select = "getDept"
            ))
    })
    List<User> getUsers(String username);

    @Insert("insert into user (username,password,sex,birthday,address) " +
            "values(#{username},#{password},#{sex},#{birthday},#{address})")
    Integer addUser(User user);

    @Delete("delete from user where id in (${value})")
    Integer deleteUser(String ids);

    @Update("update user set " +
            "username = #{username}," +
            "password = #{password}," +
            "sex = #{sex}," +
            "birthday = #{birthday}," +
            "address = #{address} " +
            "where " +
            "id = #{id}")
    Integer updateUser(User user);

    @Select("select a.* from t_dept a join dept_user b on a.id = b.dept_id and b.user_id = #{id}")
    Dept getDept(int id);
}
