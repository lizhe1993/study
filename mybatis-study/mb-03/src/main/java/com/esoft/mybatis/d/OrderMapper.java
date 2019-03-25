package com.esoft.mybatis.d;

import com.esoft.mybatis.m.Order;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

/**
 * Created by query on 2017/6/27.
 */
public interface OrderMapper {

    @Select("select * from tb_order where id=#{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "code",property = "code"),
            @Result(column = "total",property = "total"),
            @Result(column = "user_id",property = "user",
                    one =@One(select = "com.esoft.mybatis.d.UserMapper.selectUserById",fetchType = FetchType.EAGER)),
            @Result(column = "id",property = "articles",
                    many =@Many(select = "com.esoft.mybatis.d.ArticleMapper.selectByOrderId",fetchType = FetchType.LAZY))
    })
    public Order selectById(Integer id);


}
