package com.lz.springboot.shiro.jwt.springbootshirojwt.controller;

import com.lz.springboot.shiro.jwt.springbootshirojwt.base.JsonResponse;
import com.lz.springboot.shiro.jwt.springbootshirojwt.base.JsonResponseBuilder;
import com.lz.springboot.shiro.jwt.springbootshirojwt.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * ClassName: ExceptionController
 * Description:
 * Author: LiZhe lizhej@enn.cn
 * Date: 2019/4/16 16:47
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public JsonResponse handle401(ShiroException e) {
        log.error("ShiroException exception :{}", e.getMessage());
        return JsonResponseBuilder.create(HttpStatus.UNAUTHORIZED, e.getMessage(), null);
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public JsonResponse handle401(UnauthorizedException e) {
        log.error("UnauthorizedException exception :{}", e.getMessage());
        return JsonResponseBuilder.create(HttpStatus.UNAUTHORIZED, "Unauthorized", null);
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JsonResponse globalException(HttpServletRequest request, Throwable ex) {
        log.error("globalException exception :{}", ex.getMessage());
        return JsonResponseBuilder.create(getStatus(request), ex.getMessage(), null);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
