package com.masai.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timeStamp;
	private String message;
	private String uri;
	
	public ErrorDetails(LocalDateTime timeStamp, String message, String uri) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.uri = uri;
	}
	
	
}
