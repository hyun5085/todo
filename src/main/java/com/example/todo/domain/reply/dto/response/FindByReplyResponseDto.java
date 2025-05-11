package com.example.todo.domain.reply.dto.response;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class FindByReplyResponseDto {
	private Long commentId;
	private Long writerId;
	private Long todoId;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime updatedAt;

	private UpdateReplyResponseDto reply;

	public FindByReplyResponseDto(
		Long commentId,
		Long writerId,
		Long todoId,
		String content,
		LocalDateTime createdAt,
		LocalDateTime updatedAt,
		UpdateReplyResponseDto reply
	){
		this.commentId = commentId;
		this.writerId = writerId;
		this.todoId = todoId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.reply = reply;
	}
}
