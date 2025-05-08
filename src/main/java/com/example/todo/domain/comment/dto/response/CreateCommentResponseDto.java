package com.example.todo.domain.comment.dto.response;

import java.time.LocalDateTime;

import com.example.todo.domain.todo.dto.response.CreateTodoResponseDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class CreateCommentResponseDto {
	private Long commentId;
	private Long writerId;
	private Long todoId;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;

	public CreateCommentResponseDto(Long commentId, Long writerId, Long todoId, String content, LocalDateTime createdAt){
		this.commentId = commentId;
		this.writerId = writerId;
		this.todoId = todoId;
		this.content = content;
		this.createdAt = createdAt;
	}
}
