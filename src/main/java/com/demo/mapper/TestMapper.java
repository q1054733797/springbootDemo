package com.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: TestMapper
 * @Author: zhanghongkai
 * @Date: Create in 2018/10/29 11:05
 * @Version: 1.0
 */
public interface TestMapper {
    @Insert("insert into t_test(date,name) values(#{date},#{name})")
    Integer isertTest(@Param("name") String name,@Param("date") Date date);

    @Delete("delete from t_test")
    Integer deleteAll();

    @Select("Select * from t_test where date > #{beginTime} and date < #{endTime}")
    List<HashMap<String,Object>> selectBYTime(@Param("beginTime") Date beginTime, @Param("endTime") Date endTime);

    @Select("select * from t_test")
    List<HashMap<String,Object>> selectAll();

    @Insert("insert into t_test(date,name) values(#{date},#{name})")
    Integer isertTestByHashMap(HashMap<String,Object> map);
}
