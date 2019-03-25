package com.esoft.example.c;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example8")
public class Example8 {

    private static final Log logger = LogFactory.getLog(Example8.class);

    @RequestMapping(value = "/pathVariableTest/{userId}")
    public void e1(@PathVariable String userId) {
        logger.info("通过@pathVariable获取的数据：" + userId);
    }

    @RequestMapping(value = "/requestHeaderTest")
    public void e2(@RequestHeader("User-Agent") String userAgent, @RequestHeader(value = "Accept") String[] accepts) {
        logger.info("通过@RequestHeader获取的数据:" + userAgent);
        for (String accept : accepts) {
            logger.info(accept);
        }

    }

    @RequestMapping(value = "/cookieValueTest")
    public void e3(@CookieValue(value = "JSESSIONID", defaultValue = "") String sessionId) {
        logger.info("通过@CookieValue获取的数据:" + sessionId);
    }


}
