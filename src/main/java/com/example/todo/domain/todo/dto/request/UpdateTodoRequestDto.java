package com.example.todo.domain.todo.dto.request;

import lombok.Getter;

@Getter
public class UpdateTodoRequestDto {
	private Long writerId;
	private String title;
	private String content;
}
