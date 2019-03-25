package com.esoft.mybatis.d;

import com.esoft.mybatis.m.Card;
import org.apache.ibatis.annotations.Select;

/**
 * Created by query on 2017/6/27.
 */
public interface CardMapper {

    @Select("select * from tb_card where id=#{id}")
    public Card selectCardById(Integer id);
}
