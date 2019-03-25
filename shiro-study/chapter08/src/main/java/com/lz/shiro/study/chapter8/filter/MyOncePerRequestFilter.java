package com.lz.shiro.study.chapter8.filter;

import org.apache.shiro.web.servlet.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by lz on 2017/3/16.
 */
public class MyOncePerRequestFilter extends OncePerRequestFilter {

    protected void doFilterInternal(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("===once per request filter");
        chain.doFilter(request,response);
    }
}
