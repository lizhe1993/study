package com.springcloud.study;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ServiceHiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
	}

	@Value("${server.port}")
	private String port;


	private static final Logger LOG = Logger.getLogger(ServiceHiApplication.class.getName());


	@RequestMapping("/hi")
	public String home(@RequestParam String name) {
		LOG.log(Level.INFO, "hi is being called");
		//return "hi "+name+",i am from port:" +port;
		return "hi i'm service-hi!";
	}

}
