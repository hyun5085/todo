package com.example.todo.domain.comment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.domain.comment.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByTodo_IdOrderByCreatedAtDesc(Long todoId);

	// N+1 문제 있는 코드
	// Long countByTodoId(Long todoId);
}
