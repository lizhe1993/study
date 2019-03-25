package com.esoft.example.c;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
public class Example2 {

    private static final Log logger = LogFactory.getLog(Example2.class);

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        logger.info("example2 被调用");
        ModelAndView mv = new ModelAndView();
        mv.addObject("message","hello world!");
        mv.setViewName("/WEB-INF/content/welcome.jsp");
        return mv;
    }

}
