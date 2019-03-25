package com.esoft.example.c;


import com.esoft.example.m.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example10")
public class Example10 {

    private static final Log logger = LogFactory.getLog(Example10.class);

    @RequestMapping(value = "/{formName}")
    public String e1(@PathVariable String formName, Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return formName;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String e2(@ModelAttribute @Validated User user, Model model, HttpServletRequest request) {
        if (user.getUsername() != null && "lizhe".equals(user.getUsername()) && user.getPassword() != null && "123abc".equals(user.getPassword())){
            RequestContext requestContext = new RequestContext(request);
            String name = requestContext.getMessage("name");
            model.addAttribute("name",name);
            return "success";
        }
        return "error";
    }


}
