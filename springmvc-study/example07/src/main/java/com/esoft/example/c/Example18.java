package com.esoft.example.c;


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

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;

/**
 * 类springmvc注释说明:
 * <p></p>
 *
 * @author ${user}-QUERYBYLJS@163.com 金鼎科技
 * @version 6.0.0 ${date}
 */
@Controller
@RequestMapping("/example18")
public class Example18 {
    private static final Log logger = LogFactory.getLog(Example18.class);

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String e1( @ModelAttribute User user,Model model,HttpServletRequest request ) throws  Exception{
        logger.info(user.getUsername());
        MultipartFile file = user.getImage();
        if(!file.isEmpty()){
            String path= request.getServletContext().getRealPath("/image/");
            String filename = file.getOriginalFilename();
            File filepath = new File(path,filename);
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path+File.separator+filename));
            model.addAttribute("user",user);
            return "userInfo";
        }else{
            return "error";
        }
    }

    @RequestMapping(value = "/download")
    public ResponseEntity<byte[]> e2(HttpServletRequest request, @RequestParam("filename") String filename, Model model) throws Exception {
        String path = request.getServletContext().getRealPath("/image/");
        File file = new File(path+File.separator+filename);
        HttpHeaders headers = new HttpHeaders();
        String downlaodFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",downlaodFileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }
}
