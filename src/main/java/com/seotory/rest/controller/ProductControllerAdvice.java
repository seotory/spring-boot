package com.seotory.rest.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.seotory.rest.domain.RestResponse;

@Component
@ControllerAdvice("com.seotory.rest.controller")
public class ProductControllerAdvice {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<?> noHandlerFoundException(Exception e) {
		RestResponse restResponse = 
				new RestResponse(HttpStatus.NOT_FOUND, e.getMessage());
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNoValidException(Exception e) {
		e.printStackTrace();
		RestResponse restResponse = 
				new RestResponse(HttpStatus.BAD_REQUEST, e.getMessage());
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exception(Exception e) {
		RestResponse restResponse = 
				new RestResponse(HttpStatus.EXPECTATION_FAILED, e.getMessage());
		return ResponseEntity.status(restResponse.getStatus()).body(restResponse);
	}
	
}
