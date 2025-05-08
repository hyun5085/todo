package com.example.todo.domain.comment.entity;

import com.example.todo.common.entity.BaseEntity;
import com.example.todo.domain.todo.entity.Todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "comments")
public class Comment extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Long writerId;

	@ManyToOne
	@Column(nullable = false)
	private Todo todo;

	@Column(nullable = false)
	private String content;

}
