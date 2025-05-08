package com.example.todo.domain.todo.entity;


import com.example.todo.common.entity.BaseEntity;
import com.example.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.example.todo.domain.todo.dto.request.UpdateTodoRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "todos")

public class Todo extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private Long writerId;

	@Column(nullable = false)
	private String title;

	private String content;

	public Todo(){}

	public Todo(
		Long id,
		Long writerId,
		String title,
		String content
		) {
		this.id = id;
		this.writerId = writerId;
		this.title=title;
		this.content = content;
	}

	public Todo(CreateTodoRequestDto createTodoRequestDto) {
		this.writerId = createTodoRequestDto.getWriterId();
		this.title = createTodoRequestDto.getTitle();
		this.content = createTodoRequestDto.getContent();
	}

	public void UpdateTodo(UpdateTodoRequestDto updateTodoRequestDto){
		this.writerId = updateTodoRequestDto.getWriterId();
		this.title = updateTodoRequestDto.getTitle();
		this.content = updateTodoRequestDto.getContent();
	}
}
