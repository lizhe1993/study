package com.esoft.mybatis.d;

import com.esoft.mybatis.m.Student;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by query on 2017/6/27.
 */
public interface StudentMapper {

    @Select("select * from tb_student where clazz_id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age")
    })
    public List<Student> selectByClazzId(Integer clazz_id);
}
