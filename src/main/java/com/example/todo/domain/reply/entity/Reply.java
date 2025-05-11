package com.example.todo.domain.reply.entity;

import org.hibernate.mapping.ToOne;

import com.example.todo.common.entity.BaseEntity;
import com.example.todo.domain.comment.entity.Comment;
import com.example.todo.domain.todo.entity.Todo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "replies")
public class Reply extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private Long writerId;

	@ManyToOne
	@JoinColumn(name = "todo_id", nullable = false)
	private Todo todo;

	@OneToOne
	@JoinColumn(name = "comment_id", nullable = false)
	private Comment comment;

	@Column(nullable = false)
	private String content;

	public Reply(){}

	public Reply(Long writerId, Todo todo, Comment comment, String content){
		this.writerId = writerId;
		this.todo = todo;
		this.comment = comment;
		this.content = content;
	}

}
