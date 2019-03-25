package com.esoft.example.c;


import com.esoft.example.m.User;
import com.esoft.example.v.UserValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example15")
public class Example15 {

    private static final Log logger = LogFactory.getLog(Example15.class);

    @Autowired
    @Qualifier("userValidator")
    private UserValidator userValidator;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String e2(@ModelAttribute User user, Model model, Errors errors) {
        logger.info(user);
        model.addAttribute("user",user);
        userValidator.validate(user,errors);
        if(errors.hasErrors()){
            return "login";
        }
        return "success";
    }


}
