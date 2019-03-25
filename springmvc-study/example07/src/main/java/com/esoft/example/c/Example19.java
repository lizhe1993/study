package com.esoft.example.c;


import com.esoft.example.m.Book;
import com.esoft.example.m.User;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.portlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
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
@RequestMapping("/example19")
public class Example19 {
    private static final Log logger = LogFactory.getLog(Example19.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String e1(String username, String password, Model model, HttpSession session) throws Exception {
        System.out.println("AAA");
        if (username != null && username.equals("lizhe") && password != null && password.equals("123abc")) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            session.setAttribute("user", user);
            return "redirect:/example19/main";
        } else {
            model.addAttribute("message","登录名或密码错误，请重新输入！");
            return "loginForm";
        }
    }

    @RequestMapping(value = "/main")
    public String e3(Model model){
        List<Book> books = new ArrayList<Book>();
        books.add(new Book("你好李慧珍","李慧珍","DSC02035.JPG",15.2));
        books.add(new Book("你好李慧明","李慧明","DSC02042.JPG",15.3));
        books.add(new Book("你好李慧聪","李慧聪","DSC02064.JPG",15.4));
        books.add(new Book("你好李慧慧","李慧慧","DSC02072.JPG",15.5));
        model.addAttribute("books",books);
        return "main";
    }

}
