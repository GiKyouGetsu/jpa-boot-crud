package com.avaya.me;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.avaya.me.mapper")
public class PostgresMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgresMybatisApplication.class, args);
	}
}
