package com.esoft.example.c;


import com.esoft.example.i.DateEditor;
import com.esoft.example.m.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example14")
public class Example14 {

    private static final Log logger = LogFactory.getLog(Example14.class);

    //@InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new DateEditor("yyyy/MM/dd"));
    }

    @RequestMapping(value = "/{formName}")
    public String e1(@PathVariable String formName) {
        return formName;
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String e2(@ModelAttribute User user, Model model) {
        logger.info(user);
        model.addAttribute("user",user);
        return "success14";
    }


}
