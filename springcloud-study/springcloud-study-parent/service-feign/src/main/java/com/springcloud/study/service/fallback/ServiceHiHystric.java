package com.springcloud.study.service.fallback;

import com.springcloud.study.service.ServiceHi;
import org.springframework.stereotype.Component;

/**
 * Created by query on 2017/11/9.
 */
@Component
public class ServiceHiHystric implements ServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}
