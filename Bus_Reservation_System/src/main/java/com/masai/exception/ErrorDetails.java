package com.masai.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
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
