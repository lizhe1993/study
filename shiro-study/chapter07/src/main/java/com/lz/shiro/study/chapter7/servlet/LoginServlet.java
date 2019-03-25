package com.lz.shiro.study.chapter7.servlet;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lz on 2017/3/14.
 */
@WebServlet(name = "loginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String error = null;

        String username=req.getParameter("username");
        String passwrod=req.getParameter("password");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,passwrod);
        token.setRememberMe(true);
        try {
            subject.login(token);
        }catch (UnknownAccountException e1){
            error="用户名/密码错误";
        }catch (IncorrectCredentialsException e2){
            error="用户名/密码错误";
        }catch (AuthenticationException e) {
            error="其他的错误："+e.getMessage();
        }


        if(error!=null){
            req.setAttribute("error",error);
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/WEB-INF/jsp/loginSuccess.jsp").forward(req,resp);
        }



        super.doPost(req, resp);
    }
}
