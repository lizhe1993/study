package com.esoft.mybatis.d;

import com.esoft.mybatis.m.Clazz;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by query on 2017/6/27.
 */
public interface ClazzMapper {

    @Select("select * from tb_clazz where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "code",property = "code"),
            @Result(column = "id",property = "students",
            many = @Many(select = "com.esoft.mybatis.d.StudentMapper.selectByClazzId",
                    fetchType = FetchType.LAZY))
    })
    public Clazz selectById(Integer id);


}
