package com.esoft.mybatis.d;

import com.esoft.mybatis.m.Article;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by query on 2017/6/27.
 */
public interface ArticleMapper {

    @Select("select * from tb_article where id in (select article_id from tb_item where order_id=#{id})")
    public List<Article> selectByOrderId(Integer order_id);

}
