package com.seotory.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.seotory.rest"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		List<Object> list = new ArrayList<>();
		list.add("11");
		list.add(13123123);
		list.add(new int[]{1,2,4,5});
		test1(list);
		test2(list);
	}
	
	public static void test1 (List<Object> list) {
		for (Object obj : list)
			System.out.println(obj + "");
		System.out.println("");
	}
	
	public static <T> void test2 (List<T> list) {
		for (T obj : list)
			System.out.println(obj + "");
		System.out.println("");
	}
}
