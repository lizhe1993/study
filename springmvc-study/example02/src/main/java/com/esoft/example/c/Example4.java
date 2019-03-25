package com.esoft.example.c;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping(value = "/user")
public class Example4 {

    private static final Log logger = LogFactory.getLog(Example4.class);

    @RequestMapping(value = "/register")
    public String register() {

        logger.info("注册调用");

        return "register";
    }

    @RequestMapping(value = "/login")
    public String login() {
        logger.info("登录调用");
        return "login";
    }

}
