package com.seotory.rest.domain;

import org.springframework.http.HttpStatus;

public class RestResponse {
	
	private HttpStatus status;
	private int code;
	private String message;
	private Object data;
	
	public RestResponse(HttpStatus status, String message, Object data) {
		this.status = status;
		this.code = status.value();
		this.message = message;
		this.data = data;
	}

	public HttpStatus getStatus() {
		return status;
	}
	
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}

}
