package com.esoft.example.c;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
public class Example3 {

    private static final Log logger = LogFactory.getLog(Example3.class);

    @RequestMapping(value = "/helloWorld")
    public String helloWorld(Model model) {
        logger.info("example3 被调用");

        model.addAttribute("message","hello world!");


        return "helloWorld";
    }

}
