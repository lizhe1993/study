package com.esoft.example.c;


import com.esoft.example.m.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example7")
public class Example7 {

    private static List<User> userList;

    public Example7(){
        super();
        userList = new ArrayList<User>();
    }

    private static final Log logger = LogFactory.getLog(Example7.class);

    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String registerForm(){
        logger.info("register GET 方法被调用..");
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(@RequestParam String username,@RequestParam String password){
        logger.info("register POST 方法被调用...");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        userList.add(user);
        return "loginForm";
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam String username,@RequestParam String password,Model model){
        logger.info("username："+username+"password:"+password);
        for(User user:userList){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                model.addAttribute("user",user);
                return "welcome";
            }
        }

        return "loginForm";
    }


}
