package com.example.todo.domain.comment.dto.request;

import lombok.Getter;

@Getter
public class UpdateCommentRequestDto {
	private Long writerId;
	private String content;
}
