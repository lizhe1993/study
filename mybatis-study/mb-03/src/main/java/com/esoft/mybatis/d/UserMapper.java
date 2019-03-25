package com.esoft.mybatis.d;

import com.esoft.mybatis.m.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by query on 2017/6/27.
 */
public interface UserMapper {

    @Insert("insert into tb_user(name,sex,age) values(#{name},#{sex},#{age})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    public int saveUser(User user);

    @Delete("delete from tb_user where id=#{id}")
    public int delUser(@Param("id") Integer id);

    @Update("update tb_user set name=#{name},sex=#{sex},age=#{age} where id=#{id}")
    public int updateUser(User user);

    @Select("select * from tb_user where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age")
    })
    public User selectUserById(Integer id);

    @Select("select * from tb_user")
    public List<User> selectUser();
}
