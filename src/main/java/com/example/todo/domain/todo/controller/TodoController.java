package com.example.todo.domain.todo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.example.todo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.example.todo.domain.todo.dto.response.CreateTodoResponseDto;
import com.example.todo.domain.todo.dto.response.UpdateTodoResponseDto;
import com.example.todo.domain.todo.service.TodoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/todos")
@RequiredArgsConstructor
public class TodoController {

	private final TodoService todoService;

	@PostMapping
	public ResponseEntity<CreateTodoResponseDto> createTodo(
		@Valid @RequestBody CreateTodoRequestDto createTodoRequestDto
	){
		CreateTodoResponseDto createTodoResponseDto = todoService.createTodo(createTodoRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createTodoResponseDto);
	}

	@GetMapping
	public ResponseEntity<List<UpdateTodoResponseDto>> findAllTodo(){
		List<UpdateTodoResponseDto> updateTodoResponseDtoList = todoService.findAllTodos();
		return ResponseEntity.ok(updateTodoResponseDtoList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UpdateTodoResponseDto> findById(@PathVariable Long id){
		UpdateTodoResponseDto findTodo = todoService.findById(id);
		return ResponseEntity.ok(findTodo);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<UpdateTodoResponseDto> updateTodo(@PathVariable Long id,
		@Valid @RequestBody UpdateTodoRequestDto updateTodoRequestDto
	){
		UpdateTodoResponseDto updateTodoResponseDto = todoService.updateTodo(id, updateTodoRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(updateTodoResponseDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
		todoService.deleteTodo(id);
		return ResponseEntity.noContent().build();
	}
}
