package com.cg.fms.validator;

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
import com.cg.fms.exception.ConfirmPasswordException;
import com.cg.fms.exception.InvalidEmailAndPassword;
import com.cg.fms.exception.UserDoesNotExist;
import com.cg.fms.exception.UserEmailAlreadyExistException;
import com.cg.fms.exception.*;
import com.cg.fms.exception.UserNameException;


@ControllerAdvice
public class ValidationMessages extends ResponseEntityExceptionHandler{
	
	
	@ExceptionHandler(value = UserEmailAlreadyExistException.class)
	public ResponseEntity<Object> exception3(UserEmailAlreadyExistException exception) {

		return new ResponseEntity<>(" User already exist with the mail Id !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = AdminSchedulerEmailAlreadyExistException.class)
	public ResponseEntity<Object> exception3(AdminSchedulerEmailAlreadyExistException exception) {

		return new ResponseEntity<>(" Scheduler already exist with the  mail Id !! ", HttpStatus.NOT_FOUND);

	}
	
	
	
	@ExceptionHandler(value = UserNameException.class)
	public ResponseEntity<Object> exception3(UserNameException exception) {

		return new ResponseEntity<>(" User already exist with the userNAme  !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = AdminSchedulerNameException.class)
	public ResponseEntity<Object> exception3(AdminSchedulerNameException exception) {

		return new ResponseEntity<>(" User already exist with the userNAme  !! ", HttpStatus.NOT_FOUND);

	}
	
	
	@ExceptionHandler(value = AdminSchedulerDoesNotExist.class)
	public ResponseEntity<Object> exception4(AdminSchedulerDoesNotExist exception) {

		return new ResponseEntity<>(" user does not exist !! ", HttpStatus.NOT_FOUND);

	}
	
	@ExceptionHandler(value = InvalidEmailAndPassword.class)
	public ResponseEntity<Object> exception4(InvalidEmailAndPassword exception) {

		return new ResponseEntity<>(" Invalid mail-Id and password ", HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(value = ConfirmPasswordException.class)
	public ResponseEntity<Object> exception4(ConfirmPasswordException exception) {

		return new ResponseEntity<>(" Password and confirm Password Does not Match ", HttpStatus.NOT_FOUND);

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