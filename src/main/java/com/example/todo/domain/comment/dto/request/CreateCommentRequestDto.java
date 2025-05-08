package com.example.todo.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class CreateCommentRequestDto {
	private Long writerId;
	private Long todoId;
	private String content;
}
