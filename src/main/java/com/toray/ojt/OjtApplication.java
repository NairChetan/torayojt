package com.toray.ojt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.toray.ojt.web.mapper")
public class OjtApplication {

	public static void main(String[] args) {
		SpringApplication.run(OjtApplication.class, args);
	}

}
