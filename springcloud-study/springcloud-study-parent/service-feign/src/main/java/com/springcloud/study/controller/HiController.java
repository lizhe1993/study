package com.springcloud.study.controller;

import com.springcloud.study.service.ServiceHi;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by query on 2017/11/8.
 */
@RestController
public class HiController {

    private static final Logger LOG = Logger.getLogger(HiController.class.getName());


    @Autowired
    ServiceHi serviceHi;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String sayHi(@RequestParam String name){
        LOG.log(Level.INFO, "calling trace service-feign ");
        return serviceHi.sayHiFromClientOne(name);
    }

    @RequestMapping("/info")
    public String info(){
        LOG.log(Level.INFO, "calling trace service-feign ");
        return "i'm service-feign";
    }
}
