package com.example.todo.domain.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.domain.todo.entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
	Long id(Long id);
}
