package com.pattern.validation.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleValdationFailure(ConstraintViolationException ex) {
		
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.OK);
	}

}
