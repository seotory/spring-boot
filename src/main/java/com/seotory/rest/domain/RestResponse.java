package com.seotory.rest.domain;

import org.springframework.http.HttpStatus;

public class RestResponse {
	
	private HttpStatus status;
	private int code;
	private String message;
	private Object data;
	
	public RestResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public RestResponse(HttpStatus status, String message) {
		this(status, message, null);
	}
	
	public RestResponse(HttpStatus status, String message, Object data) {
		this.status = status;
		this.code = status.value();
		this.message = message;
		this.data = data;
	}

	public RestResponse setStatus(HttpStatus status) {
		this.status = status;
		this.code = status.value();
		return this;
	}

	public RestResponse setMessage(String message) {
		this.message = message;
		return this;
	}

	public RestResponse setData(Object data) {
		this.data = data;
		return this;
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
