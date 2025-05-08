package com.example.todo.domain.todo.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.example.todo.domain.comment.dto.response.CreateCommentResponseDto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class FindByTodoResponseDto {
	private Long todoId;
	private Long writerId;
	private String title;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime updatedAt;

	private List<CreateCommentResponseDto> comment;

	public FindByTodoResponseDto(Long todoId, Long writerId, String title, String content,
		LocalDateTime createdAt, LocalDateTime updatedAt,
		List<CreateCommentResponseDto> comment) {
		this.todoId = todoId;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.comment = comment;
	}
}
