package com.esoft.example.f;


import com.esoft.example.m.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类spring-mvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
public class AuthorizationInterceptor implements HandlerInterceptor {

    private static final String[] IGNORE_URI = {"/tool/t1/loginForm","/example19/login"};

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("AuthorizationInterceptor preHandle-->");

        boolean flag = false;

        String servletPath = request.getServletPath();
        for(String s : IGNORE_URI){
            if(servletPath.contains(s)){
                flag = true;
                break;
            }
        }
        if(!flag){
            User user = (User) request.getSession().getAttribute("user");
            if(user==null){
                System.out.println("AuthorizationInterceptor拦截请求:");
                request.setAttribute("message","请先登录在访问网站");
                request.getRequestDispatcher("/tool/t1/loginForm").forward(request,response);
            }else{
                System.out.println("AuthorizationInterceptor放行请求:");
                flag = true;
            }
        }
        return flag;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("AuthorizationInterceptor postHandle-->");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("AuthorizationInterceptor afterCompletion-->");
    }
}
