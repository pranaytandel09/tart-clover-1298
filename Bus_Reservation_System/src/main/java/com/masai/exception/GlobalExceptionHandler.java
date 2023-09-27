package com.masai.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails>MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e, WebRequest request){
		
		List<ObjectError> allErrors = e.getAllErrors();
		List<String> errorsToStringList = MethodArgumentNotValidException.errorsToStringList(allErrors);
		
		String message= String.join(", ", errorsToStringList);
		
		return new ResponseEntity<ErrorDetails>(new ErrorDetails(LocalDateTime.now(), message, request.getDescription(false)), HttpStatus.BAD_REQUEST);
	}
}
