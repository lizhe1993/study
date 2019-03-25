package com.lz.shiro.study.chapter6.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * Created by lz on 2017/3/13.
 */
public class MyRealm1 implements Realm {

    public String getName() {

        return "my realm 1";
    }

    public boolean supports(AuthenticationToken token) {
        return token instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        return new SimpleAuthenticationInfo("zhang","123",getName());
    }
}
