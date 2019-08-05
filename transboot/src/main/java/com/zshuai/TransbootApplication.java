package com.zshuai;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement // 开启注解事务管理，等同于xml配置文件中的 <tx:annotation-driven />
@SpringBootApplication
@MapperScan("com.zshuai.dao")
public class TransbootApplication {

	public final static Logger logger = LoggerFactory.getLogger(TransbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TransbootApplication.class, args);
		logger.trace("trace level");
        logger.debug("debug level");
        logger.info("info level");
        logger.warn("warn level");
        logger.error("error level");

	}

}
