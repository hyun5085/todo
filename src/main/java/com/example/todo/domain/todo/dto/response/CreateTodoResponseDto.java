package com.example.todo.domain.todo.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class CreateTodoResponseDto {
	private Long todoId;
	private Long writerId;
	private String title;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;

	public CreateTodoResponseDto(Long todoId, Long writerId, String title, String content, LocalDateTime createdAt){
		this.todoId = todoId;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}
}
