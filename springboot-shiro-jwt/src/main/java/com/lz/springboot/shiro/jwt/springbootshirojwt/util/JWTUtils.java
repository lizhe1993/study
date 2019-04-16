package com.lz.springboot.shiro.jwt.springbootshirojwt.util;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * ClassName: JWTUtils
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/4/16 11:25
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Slf4j
public class JWTUtils {
    //过期时间
    private static final long EXPIRE_TIME = 5 * 60 * 100;

    /**
     * 生签名，5分钟之后过期
     *
     * @param username 用户名
     * @param secret   密码
     * @return 返回签名
     */
    public static String sign(String username, String secret) {
        try {
            Date expireDate = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            return JWT.create().withClaim("username", username).withExpiresAt(expireDate).sign(Algorithm.HMAC256(secret));
        } catch (IllegalArgumentException e) {
            log.error("create jwt token error IllegalArgumentException:{}", e.getMessage());
        } catch (JWTCreationException e) {
            log.error("create jwt token error JWTCreationException:{}", e.getMessage());
        }
        return null;
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            log.error("get username by token is error JWTDecodeException:{}", e.getMessage());
        }
        return null;
    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            DecodedJWT userInfo = JWT.require(Algorithm.HMAC256(secret)).withClaim("username", username).build().verify(token);
            log.info("decoded jwt info:{}", JSON.toJSONString(userInfo));
            return true;
        } catch (JWTVerificationException e) {
            log.error("jwt verify is error JWTVerificationException:{}", e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("jwt verify is error IllegalArgumentException:{}", e.getMessage());
        }
        return false;
    }
}
