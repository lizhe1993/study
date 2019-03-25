package com.esoft.example.c;


import com.esoft.example.m.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
public class Example5 {

    private static final Log logger = LogFactory.getLog(Example5.class);

    @ModelAttribute
    public void userModel(String username, String password, Model model) {
        logger.info("user model example");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        model.addAttribute("user",user);
    }

    @RequestMapping(value = "/login1")
    public String login(Model model) {
        logger.info("登录调用 login1");
        User user = (User) model.asMap().get("user");
        System.out.println(user.toString());
        user.setUsername("测试");
        return "login";
    }

}
