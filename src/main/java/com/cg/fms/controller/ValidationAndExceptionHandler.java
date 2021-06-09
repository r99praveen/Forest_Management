package com.cg.fms.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.cg.fms.exception.CustomerNotFoundException;
import com.cg.fms.exception.InvalidOrderException;
import com.cg.fms.exception.ProductNotFoundExcption;

@ControllerAdvice
public class ValidationAndExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = CustomerNotFoundException.class)
	public ResponseEntity<Object> exception(CustomerNotFoundException exception) {

		return new ResponseEntity<>("Customer Not Found!!", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = ProductNotFoundExcption.class)
	public ResponseEntity<Object> exception(ProductNotFoundExcption exception) {

		return new ResponseEntity<>("Product Not Found!!", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = InvalidOrderException.class)
	public ResponseEntity<Object> exception2(InvalidOrderException exception) {

		return new ResponseEntity<>("Invalid Order!!", HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
