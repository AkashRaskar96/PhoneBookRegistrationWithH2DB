package com.adt.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(value = ContactNotFound.class)
	public ResponseEntity<AppError> handelNoContactFoundException() {
		AppError error=new AppError(400,"Contact Not Found",new Date());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
}
