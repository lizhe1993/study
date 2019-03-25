package com.lz.shiro.study.chapter6;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by lz on 2017/3/8.
 */
public class JdbcTemplateUtils {
    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate jdbcTemplate(){
        if(jdbcTemplate==null){
            jdbcTemplate = createJdbcTemplate();
        }
        return  jdbcTemplate;
    }

    private static JdbcTemplate createJdbcTemplate() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://lz-pc:3306/shiro");
        ds.setUsername("root");
        ds.setPassword("mysql");
        return new JdbcTemplate(ds);
    }
}
