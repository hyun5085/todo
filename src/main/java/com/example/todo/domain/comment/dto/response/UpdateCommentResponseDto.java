package com.example.todo.domain.comment.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class UpdateCommentResponseDto {
	private Long commentId;
	private Long writerId;
	private Long todoId;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime updatedAt;

	public UpdateCommentResponseDto(
		Long commentId,
		Long writerId,
		Long todoId,
		String content,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	){
		this.commentId = commentId;
		this.writerId = writerId;
		this.todoId = todoId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
