package com.example.todo.domain.todo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.todo.domain.todo.dto.response.FindAllTodoResponseDto;
import com.example.todo.domain.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

	// N+1 문제 해결
	@Query("SELECT new com.example.todo.domain.todo.dto.response.FindAllTodoResponseDto(t, COUNT(c)) " +
		"FROM Todo t LEFT JOIN Comment c ON t.id = c.todo.id " +
		"GROUP BY t")
	List<FindAllTodoResponseDto> findAllWithCommentCount();
}
