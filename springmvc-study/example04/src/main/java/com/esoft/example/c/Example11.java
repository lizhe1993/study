package com.esoft.example.c;


import com.esoft.example.m.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example11")
public class Example11 {

    private static final Log logger = LogFactory.getLog(Example11.class);

    @RequestMapping(value = "/{formName}")
    public String e1(@PathVariable String formName,
                     @RequestParam(required = false) String request_locale, Model model,HttpServletRequest request) {

        logger.info("request_locale = "+request_locale);
        if(request_locale!=null){
            if(request_locale.equals("zh_CN")){
                Locale locale = new Locale("zh","CN");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }else if(request_locale.equals("en_US")){
                Locale locale = new Locale("en","US");
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            }else{
                request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, LocaleContextHolder.getLocale());
            }
        }
        User user = new User();
        model.addAttribute("user", user);
        return formName;
    }
}
