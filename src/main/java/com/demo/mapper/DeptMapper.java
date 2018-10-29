package com.demo.mapper;

import com.demo.bean.Dept;
import com.demo.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName: DeptMapper
 * @Author: zhanghongkai
 * @Date: Create in 2018/9/7 16:48
 * @Version: 1.0
 */
public interface DeptMapper {
    @Select("select * from t_dept where name like '%${name}%'")
    @Results({
            @Result(property = "id",column ="id" ),
            @Result(property = "name",column ="name" ),
            @Result(property = "users",column ="id",many = @Many(
                    select = "getUsers"
            ))
    })
    List<Dept> getDepts(String name);

    @Select("select * from user a join dept_user b on a.id = b.user_id and b.dept_id = #{id}")
    List<User> getUsers(int id);

    @Insert("insert into t_dept(name) values(#{name})")
    int addDept(Dept dept);

    @Delete("delete from t_dept where id in (${value})")
    int deleteDept(String ids);

    @Update("update t_dept set name = #{name} where id = #{id}")
    int updateDept(Dept dept);
}
