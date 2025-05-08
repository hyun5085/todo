package com.example.todo.domain.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.example.todo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.example.todo.domain.todo.dto.response.CreateTodoResponseDto;
import com.example.todo.domain.todo.dto.response.UpdateTodoResponseDto;
import com.example.todo.domain.todo.entity.Todo;
import com.example.todo.domain.todo.repository.TodoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final TodoRepository todoRepository;

	public CreateTodoResponseDto createTodo(CreateTodoRequestDto createTodoRequestDto){
		Todo todo = new Todo(createTodoRequestDto);
		Todo createTodo = todoRepository.save(todo);
		return new CreateTodoResponseDto(
			createTodo.getId(),
			createTodo.getWriterId(),
			createTodo.getTitle(),
			createTodo.getContent(),
			createTodo.getCreatedAt()
		);
	}

	public List<UpdateTodoResponseDto> findAllTodos(){
		List<Todo> findAllTodos = todoRepository.findAll();
		ArrayList<UpdateTodoResponseDto> todosList = new ArrayList<>();
		for (Todo todo : findAllTodos){
			todosList.add(new UpdateTodoResponseDto(todo));
		}
		return todosList;
	}

	public UpdateTodoResponseDto findById(Long id){
		Optional<Todo> optionalTodo = todoRepository.findById(id);
		Todo todo = optionalTodo.get();
		return new UpdateTodoResponseDto(todo);
	}

	@Transactional
	public UpdateTodoResponseDto updateTodo(Long id, UpdateTodoRequestDto updateTodoRequestDto){
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없어."));
		todo.UpdateTodo(updateTodoRequestDto);

		return new UpdateTodoResponseDto(todo);
	}

	public void deleteTodo(Long id){
		Todo todo = todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없어."));
		todoRepository.delete(todo);
	}

}
