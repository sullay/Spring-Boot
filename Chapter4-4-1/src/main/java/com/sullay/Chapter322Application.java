package com.sullay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class Chapter322Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter322Application.class, args);
	}
}
