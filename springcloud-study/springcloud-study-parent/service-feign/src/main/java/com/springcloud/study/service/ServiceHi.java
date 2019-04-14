package com.springcloud.study.service;

import com.springcloud.study.service.fallback.ServiceHiHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by query on 2017/11/8.
 */
@FeignClient(value = "service-hi",fallback = ServiceHiHystric.class)
public interface ServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);

}
