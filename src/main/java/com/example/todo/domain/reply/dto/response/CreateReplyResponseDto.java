package com.example.todo.domain.reply.dto.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
public class CreateReplyResponseDto {
	private Long replyId;
	private Long writerId;
	private Long todoId;
	private Long commentId;
	private String content;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH-mm-ss")
	private LocalDateTime createdAt;

	public CreateReplyResponseDto(
		Long replyId,
		Long writerId,
		Long todoId,
		Long commentId,
		String content,
		LocalDateTime createdAt
	){
		this.replyId = replyId;
		this.writerId = writerId;
		this.todoId = todoId;
		this.commentId = commentId;
		this.content = content;
		this.createdAt = createdAt;
	}
}
