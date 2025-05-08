package com.example.todo.domain.comment.entity;

import com.example.todo.common.entity.BaseEntity;
import com.example.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.example.todo.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.todo.domain.todo.entity.Todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "comments")
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private Long writerId;

	@ManyToOne
	@JoinColumn(name = "todo_id", nullable = false)
	private Todo todo;

	@Column(nullable = false)
	private String content;

	public Comment(){

	}

	public Comment(Long id, Long writerId, Todo todo, String content){
		this.id = id;
		this.writerId = writerId;
		this.todo = todo;
		this.content = content;
	}

	public Comment(Long writerId, Todo todo, String content) {
		this.writerId = writerId;
		this.todo = todo;
		this.content = content;
	}

	public void UpdateComment(UpdateCommentRequestDto updateCommentRequestDto){
		this.writerId = updateCommentRequestDto.getWriterId();
		this.content = updateCommentRequestDto.getContent();
	}


}
