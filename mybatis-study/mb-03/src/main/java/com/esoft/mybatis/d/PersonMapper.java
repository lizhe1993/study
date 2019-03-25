package com.esoft.mybatis.d;

import com.esoft.mybatis.m.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by query on 2017/6/27.
 */
public interface PersonMapper {

    @Select("select * from tb_person where id=#{id}")
    @Results({
            @Result(id = true,column = "id" ,property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex"),
            @Result(column = "age",property = "age"),
            @Result(column = "card_id",property = "card",
                    one = @One(select = "com.esoft.mybatis.d.CardMapper.selectCardById",
                            fetchType = FetchType.EAGER))
    })
    public Person selectPersonMapper(Integer id);
}
