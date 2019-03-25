package com.esoft.example.c;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example17")
public class Example17 {
    private static final Log logger = LogFactory.getLog(Example17.class);

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String e1(HttpServletRequest request , @RequestParam String description , @RequestParam MultipartFile file) throws  Exception{
        logger.info(description);
        if(!file.isEmpty()){
            String path= request.getServletContext().getRealPath("/image/");
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path+File.separator+filename));
            return "success";
        }else{
            return "error";
        }
    }

}
