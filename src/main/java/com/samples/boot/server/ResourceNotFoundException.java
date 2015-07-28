package com.samples.boot.server;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public  class ResourceNotFoundException{
	/**
	 * 
	 */
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(reason="Media Type Not Supported", value= HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	public String getHttpMediaTypeNotSupportedException() throws Exception{
		return "Sorry! See documentation to make valid request";
	}

}