package com.seotory.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.seotory")
@SpringBootApplication
public class SeotoryMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeotoryMvcApplication.class, args);
	}
}
