package cn.zshuai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.zshuai.dao") 
@SpringBootApplication
public class CoverityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoverityApplication.class, args);
	}

}
