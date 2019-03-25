package com.lz.shiro.study.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by lz on 2017/2/28.
 */
public class MyRealm3 implements Realm {


    public String getName() {
        return "my realm 3";
    }

    public boolean supports(AuthenticationToken token) {
        //仅支持UsernamePasswordToken类型Token
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();//得到用户名
        String password = new String((char[])token.getCredentials());//得到密码
        if(!"zhang".equals(username)){
            throw new UnknownAccountException();//如果用户名错误
        }
        if(!"123".equals(password)){
            throw new IncorrectCredentialsException();//如果用户密码错误
        }
        //如果身份验证成功，返回一个AuthenticationInfo
        return new SimpleAuthenticationInfo(username+"@163.com",password,getName());
    }
}
