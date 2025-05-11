package com.example.todo.domain.reply.dto.request;

import lombok.Getter;

@Getter
public class CreateReplyRequestDto {
	private Long writerId;
	private Long commentId;
	private String content;
}
