package com.zshuai.springbppt.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {
	public final static Logger logger = LoggerFactory.getLogger(Application.class);
	public static void main(String[] args) throws Exception {
		logger.info("初始化成功！");
		SpringApplication.run(Application.class, args);
	}

}
