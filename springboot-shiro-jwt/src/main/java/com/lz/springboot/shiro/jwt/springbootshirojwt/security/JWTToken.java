package com.lz.springboot.shiro.jwt.springbootshirojwt.security;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.shiro.authc.AuthenticationToken;

/**
 * ClassName: JWTToken
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/4/16 17:04
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Getter
@Setter
@ToString
public class JWTToken implements AuthenticationToken {

    //秘钥
    private String token;

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }

    public JWTToken(String token) {
        this.token = token;
    }

    public JWTToken() {
    }
}
