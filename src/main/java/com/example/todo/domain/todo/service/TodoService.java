package com.example.todo.domain.todo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo.domain.comment.dto.response.CreateCommentResponseDto;
import com.example.todo.domain.comment.entity.Comment;
import com.example.todo.domain.comment.repository.CommentRepository;
import com.example.todo.domain.todo.dto.request.CreateTodoRequestDto;
import com.example.todo.domain.todo.dto.request.UpdateTodoRequestDto;
import com.example.todo.domain.todo.dto.response.CreateTodoResponseDto;
import com.example.todo.domain.todo.dto.response.FindAllTodoResponseDto;
import com.example.todo.domain.todo.dto.response.FindByTodoResponseDto;
import com.example.todo.domain.todo.dto.response.UpdateTodoResponseDto;
import com.example.todo.domain.todo.entity.Todo;
import com.example.todo.domain.todo.repository.TodoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {

	private final TodoRepository todoRepository;
	private final CommentRepository commentRepository;

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

	// public List<FindAllTodoResponseDto> findAllTodos(){
	// 	List<Todo> findAllTodos = todoRepository.findAll();
	// 	ArrayList<FindAllTodoResponseDto> todosList = new ArrayList<>();
	// 	for (Todo todo : findAllTodos){
	// 		Long commentCount = commentRepository.countByTodoId(todo.getId());
	// 		todosList.add(new FindAllTodoResponseDto(todo, commentCount));
	// 	}
	// 	return todosList;
	// }
	public List<FindAllTodoResponseDto> findAllTodos() {
		return todoRepository.findAllWithCommentCount();
	}


	public FindByTodoResponseDto findById(Long id){
		Optional<Todo> optionalTodo = todoRepository.findById(id);
		List<Comment> findByComment = commentRepository.findByTodo_IdOrderByCreatedAtDesc(id);
		ArrayList<CreateCommentResponseDto> findCommentList = new ArrayList<>();
		for (Comment comment : findByComment){
			findCommentList.add(new CreateCommentResponseDto(
				comment.getId(),
				comment.getWriterId(),
				comment.getTodo().getId(),
				comment.getContent(),
				comment.getCreatedAt()
			)
			);
		}
		Todo todo = optionalTodo.get();
		return new FindByTodoResponseDto(
			todo.getId(),
			todo.getWriterId(),
			todo.getTitle(),
			todo.getContent(),
			todo.getCreatedAt(),
			todo.getUpdatedAt(),
			findCommentList
		);

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
