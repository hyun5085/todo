package com.example.todo.domain.todo.dto.response;

import java.time.LocalDateTime;

import com.example.todo.domain.todo.entity.Todo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class UpdateTodoResponseDto {

		private Long todoId;
		private Long writerId;
		private String title;
		private String content;

		@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
		private LocalDateTime createdAt;

		@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
		private LocalDateTime updatedAt;

		public UpdateTodoResponseDto(
			Long todoId,
			Long writerId,
			String title,
			String content,
			LocalDateTime createdAt,
			LocalDateTime updatedAt
		){
			this.todoId = todoId;
			this.writerId = writerId;
			this.title = title;
			this.content = content;
			this.createdAt = createdAt;
			this.updatedAt = updatedAt;
		}

	public UpdateTodoResponseDto(Todo todo) {
		this.todoId = todo.getId();
		this.writerId = todo.getWriterId();
		this.title = todo.getTitle();
		this.content = todo.getContent();
		this.createdAt = todo.getCreatedAt();
		this.updatedAt = todo.getUpdatedAt();
	}
}
