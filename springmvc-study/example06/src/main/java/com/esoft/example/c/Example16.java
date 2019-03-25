package com.esoft.example.c;


import com.esoft.example.m.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example16")
public class Example16 {

    private static final Log logger = LogFactory.getLog(Example16.class);

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String e2(@Valid @ModelAttribute User user, Errors errors,Model model)  {
        logger.info(user);

        model.addAttribute("user",user);

        if(errors.hasErrors()){
            return "register";
        }
        return "success-register";
    }


}
