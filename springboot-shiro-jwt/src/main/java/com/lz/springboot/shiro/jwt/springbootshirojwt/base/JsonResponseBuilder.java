package com.lz.springboot.shiro.jwt.springbootshirojwt.base;

import org.springframework.http.HttpStatus;

/**
 * ClassName: JsonResponseBuilder
 * Description:
 * Date: 2019/4/16 13:55
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class JsonResponseBuilder {
    /**
     * 返回成功
     *
     * @param msg
     * @return
     */
    public static JsonResponse success(String msg) {
        return success(msg, null);
    }

    /**
     * 返回成功
     *
     * @param msg
     * @param data
     * @return
     */
    public static JsonResponse success(String msg, Object data) {
        return new JsonResponse(HttpStatus.OK.value(), msg, data);
    }

    /**
     * 创建jsonResponse
     *
     * @param status
     * @param msg
     * @param data
     * @return
     */
    public static JsonResponse create(HttpStatus status, String msg, Object data) {
        return new JsonResponse(status.value(), msg, data);
    }

}
