package com.example.todo.common.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class ErrorResponse {
	private final String code;
	private final String message;
	private final String status;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private final LocalDateTime timestamp;

	public ErrorResponse(String code, String message, HttpStatus status){
		this.code = code;
		this.message = message;
		this.status = status.name();
		this.timestamp = LocalDateTime.now();
	}
}
