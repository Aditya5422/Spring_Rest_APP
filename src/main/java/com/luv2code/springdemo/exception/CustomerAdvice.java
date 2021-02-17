package com.luv2code.springdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerAdvice {
	

	@ExceptionHandler
	public ResponseEntity<ResponseStatusException> handleException(CustomerNotFoundException exc){
		ResponseStatusException resp=new ResponseStatusException();
		resp.setStatusCode(HttpStatus.NOT_FOUND.value());
		resp.setMessage(exc.getMessage());
		resp.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ResponseStatusException> handleException(Exception exc){
		ResponseStatusException resp=new ResponseStatusException();
		resp.setStatusCode(HttpStatus.BAD_REQUEST.value());
		resp.setMessage("Please Enter Proper Id");
		resp.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
	}

}
