package com.esoft.example.c;


import com.alibaba.fastjson.JSONObject;
import com.esoft.example.m.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
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
@RequestMapping("/example9")
public class Example9 {

    private static final Log logger = LogFactory.getLog(Example9.class);

    @RequestMapping(value = "/json/testRequestBody")
    public void e1(@RequestBody Book book, HttpServletResponse response)throws Exception {
        logger.info("example9.e1被调用" );
        book.setAuthor("lizhe");
        //ObjectMapper mapper = new ObjectMapper();
        logger.info(JSONObject.toJSONString(book));
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSONObject.toJSONString(book));
    }

    @RequestMapping(value = "/json/testRequestBody1")
    @ResponseBody
    public Object e2(){
        List<Book> list = new ArrayList<Book>();
        list.add(new Book("001","spring mvc","lizhe"));
        list.add(new Book("002","spring mvc1","lizhe1"));
        return list;
    }


}
