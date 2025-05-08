package com.example.todo.domain.todo.dto.response;

import java.time.LocalDateTime;

import com.example.todo.domain.todo.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class FindAllTodoResponseDto {
	private Long todoId;
	private Long writerId;
	private String title;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime updatedAt;

	private Long commentCount;

	public FindAllTodoResponseDto(Todo todo, Long commentCount){
		this.todoId = todo.getId();
		this.writerId = todo.getWriterId();
		this.title = todo.getTitle();
		this.content = todo.getContent();
		this.createdAt = todo.getCreatedAt();
		this.updatedAt = todo.getUpdatedAt();
		this.commentCount = commentCount;
	}
}
