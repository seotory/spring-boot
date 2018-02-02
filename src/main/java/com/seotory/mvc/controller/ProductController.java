package com.seotory.mvc.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	@RequestMapping(path = {"/product/{id:[0-9]+}"}, method = RequestMethod.POST)
	public Map<String, String> add(@PathVariable("id") String id) {
		Map<String, String> json = new HashMap<String, String>();
		json.put("result", id);
		return json;
	}
	
	@RequestMapping(path = {"/product/{id:[0-9]+}"}, method = RequestMethod.GET)
	public Map<String, String> get(@PathVariable("id") String id) {
		Map<String, String> json = new HashMap<String, String>();
		json.put("result", id + "상품입니다.");
		return json;
	}
}
