package com.lz.shiro.study.chapter8.filter;

import org.apache.shiro.web.filter.PathMatchingFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Arrays;

/**
 * Created by lz on 2017/3/16.
 */
public class MyPathMatchingFilter extends PathMatchingFilter {

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        System.out.println("url matches,config is " + Arrays.toString((String[])mappedValue));
        return true;
    }
}
