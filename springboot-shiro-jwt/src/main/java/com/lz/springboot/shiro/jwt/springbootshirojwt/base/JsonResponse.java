package com.lz.springboot.shiro.jwt.springbootshirojwt.base;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName: JsonResponse
 * Description:
 * Date: 2019/4/16 13:53
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
@Getter
@Setter
@ToString
public class JsonResponse {
    //http 装填吗
    private int code;
    //返回信息
    private String msg;
    // 返回数据
    private Object data;

    public JsonResponse(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResponse() {
    }
}
