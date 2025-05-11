package com.example.todo.domain.reply.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class UpdateReplyResponseDto {
	private Long replyId;
	private Long writerId;
	private Long todoId;
	private Long commentId;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime updatedAt;

	public UpdateReplyResponseDto(
		Long replyId,
		Long writerId,
		Long todoId,
		Long commentId,
		String content,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
	){
		this.replyId = replyId;
		this.writerId = writerId;
		this.todoId = todoId;
		this.commentId = commentId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
}
