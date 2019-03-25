package com.lz.shiro.study.chapter6.realm;

import com.lz.shiro.study.chapter6.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by lz on 2017/3/13.
 */
public class MyRealm3 implements Realm {

    public String getName() {

        return "my realm 3";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        User user = new User("zhang","123");
        return new SimpleAuthenticationInfo(user,"123",getName());
    }
}
