package com.demo.mapper;

import com.demo.bean.Dept;
import com.demo.bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;

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

    @InsertProvider(type = UserProvider.class,method = "insertUser")
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

    class UserProvider{
        public String insertUser(User user){
            SQL sql = new SQL();
            sql.INSERT_INTO("t_user");
            String intoColumns = "";
            String intoValues = "";
            if(user.getUsername() != null){
                intoColumns = intoColumns+",username";
                intoValues = intoValues + ",#{username}";
            }
            if(user.getPassword() != null){
                intoColumns = intoColumns+",password";
                intoValues = intoValues + ",#{password}";
            }
            if(user.getSex() != null){
                intoColumns = intoColumns+",sex";
                intoValues = intoValues + ",#{sex}";
            }
            if(user.getBirthday() != null){
                intoColumns = intoColumns+",birthday";
                intoValues = intoValues + ",#{birthday}";
            }
            if(user.getAddress() != null){
                intoColumns = intoColumns+",address";
                intoValues = intoValues + ",#{address}";
            }
            sql.INTO_COLUMNS(intoColumns.substring(1));
            sql.INTO_VALUES(intoValues.substring(1));
            return sql.toString();
        }
    }
}
