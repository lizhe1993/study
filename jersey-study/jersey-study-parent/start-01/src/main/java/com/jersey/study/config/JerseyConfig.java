package com.jersey.study.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

/**
 * Created by query on 2017/11/12.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    private final static Logger LOGGER = Logger.getLogger(JerseyConfig.class.getName());

    public JerseyConfig() {
        packages("com.jersey.study.jer");
    }
}
