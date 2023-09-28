package com.masai.exception;

public class UserDoesNotExistException extends RuntimeException {

	public UserDoesNotExistException(String message) {
		super(message);
	}
}
