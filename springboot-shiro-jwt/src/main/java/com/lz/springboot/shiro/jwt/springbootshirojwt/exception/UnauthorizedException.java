package com.lz.springboot.shiro.jwt.springbootshirojwt.exception;

/**
 * ClassName: UnauthorizedException
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/4/16 14:01
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String message) {
        super(message);
    }

    public UnauthorizedException() {
        super();
    }
}
