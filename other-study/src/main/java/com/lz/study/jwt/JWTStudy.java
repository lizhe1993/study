/*
 * Copyright: Copyright (c) 2017-2020
 * Company: ygego
 */

package com.lz.study.jwt;

import com.auth0.jwt.JWT;
import io.jsonwebtoken.Claims;

/**
 * ClassName: JWTStudy
 * Description:
 * Date: 2019/1/9 14:56
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class JWTStudy {

    public static void main(String[] args) {

        String token  = JWTUtils.createJWT(2*60*1000, "lz");
        System.out.println(token);

        Claims claims = JWTUtils.parseJWT(token);
        System.out.println(claims.get("userId"));

        System.out.println(JWTUtils.isVerify(token,"lz"));

    }
}
