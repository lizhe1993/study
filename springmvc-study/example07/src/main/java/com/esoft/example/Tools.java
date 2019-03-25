package com.esoft.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类spring-mvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/tool")
public class Tools {

    @RequestMapping(value = "/t1/{formName}")
    public String t1(@PathVariable String formName, Model model) {
        return formName;
    }

}
