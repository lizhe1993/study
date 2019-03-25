package chapter16.web.controller;

import chapter16.entity.Resource;
import chapter16.entity.User;
import chapter16.service.ResourceService;
import chapter16.service.UserService;
import chapter16.web.bind.annotation.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;

/**
 * chapter16.web.controller.shiro-study
 * lz 创建于 2017/3/24。
 * 李哲 邮件：QUERYBYLJS@163.com
 * 描述：
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(/**@CurrentUser*/User loginUser, Model model){
        Set<String> permissions = userService.findPermissions(loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus",menus);
        return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }
}
