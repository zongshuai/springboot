package com.zshuai.springbppt.thymeleaf.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	
	public final static Logger logger = LoggerFactory.getLogger(HelloController.class);
	@RequestMapping("/hello")
	public String hello() {
		logger.info("hello方法执行!");
		return "Hello to Gradle World!";
	}
}
