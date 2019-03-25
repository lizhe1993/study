package com.esoft.example.c;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example6")
public class Example6 {

    private static final Log logger = LogFactory.getLog(Example6.class);


    @RequestMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        logger.info("登录调用 login");
        System.out.println(username+":"+password);
        return "login";
    }

}
