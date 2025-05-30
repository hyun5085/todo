package com.example.todo.domain.todo.entity;


import java.util.ArrayList;
import java.util.List;

import com.example.todo.common.entity.BaseEntity;
import com.example.todo.domain.comment.entity.Comment;
import com.example.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.example.todo.domain.todo.dto.request.UpdateTodoRequestDto;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

	@OneToMany(mappedBy = "todo", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Comment> comments = new ArrayList<>();

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
