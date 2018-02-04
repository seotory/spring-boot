package com.seotory.rest.controller;

import java.util.Collections;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
@ControllerAdvice("com.seotory.rest.controller")
public class ProductControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNoValidException(Exception e) {
		e.printStackTrace();
		return ResponseEntity.badRequest()
				.body(Collections.singletonMap("result", e.getMessage()));
	}
	
}
