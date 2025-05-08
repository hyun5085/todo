package com.example.todo.domain.comment.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.example.todo.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.todo.domain.comment.dto.response.CreateCommentResponseDto;
import com.example.todo.domain.comment.dto.response.UpdateCommentResponseDto;
import com.example.todo.domain.comment.entity.Comment;
import com.example.todo.domain.comment.repository.CommentRepository;
import com.example.todo.domain.todo.entity.Todo;
import com.example.todo.domain.todo.repository.TodoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final TodoRepository todoRepository;

	public CreateCommentResponseDto createComment(CreateCommentRequestDto createCommentRequestDto){
		Todo todo = getTodoOrThrow(createCommentRequestDto.getTodoId());
		Comment comment = new Comment(
			createCommentRequestDto.getWriterId(),
			todo,
			createCommentRequestDto.getContent()
		);
		Comment createComment = commentRepository.save(comment);
		return new CreateCommentResponseDto(
			createComment.getId(),
			createComment.getWriterId(),
			createComment.getTodo().getId(),
			createComment.getContent(),
			createComment.getCreatedAt()
		);
	}

	public List<UpdateCommentResponseDto> findAllComment(){
		List<Comment> findAllComment = commentRepository.findAll();
		ArrayList<UpdateCommentResponseDto> commentsList = new ArrayList<>();
		for (Comment comment : findAllComment){
			commentsList.add(new UpdateCommentResponseDto(
				comment.getId(),
				comment.getWriterId(),
				comment.getTodo().getId(),
				comment.getContent(),
				comment.getCreatedAt(),
				comment.getUpdatedAt()
			)
			);
		}
		return commentsList;
	}

	public UpdateCommentResponseDto findByComment(Long id){
		Optional<Comment> findComment = commentRepository.findById(id);
		Comment comment = findComment.get();
		return new UpdateCommentResponseDto(
			comment.getId(),
			comment.getWriterId(),
			comment.getTodo().getId(),
			comment.getContent(),
			comment.getCreatedAt(),
			comment.getUpdatedAt()
		);
	}

	@Transactional
	public UpdateCommentResponseDto updateComment(Long id, UpdateCommentRequestDto updateCommentRequestDto){
		Comment comment = getCommentOrThrow(id);
		comment.UpdateComment(updateCommentRequestDto);
		return new UpdateCommentResponseDto(
			comment.getId(),
			comment.getWriterId(),
			comment.getTodo().getId(),
			comment.getContent(),
			comment.getCreatedAt(),
			comment.getUpdatedAt());
	}

	public void deleteComment(Long id){
		Comment comment = getCommentOrThrow(id);
		commentRepository.delete(comment);
	}

	private Todo getTodoOrThrow(Long todoId){
		return todoRepository.findById(todoId).orElseThrow(()-> new IllegalArgumentException("없어"));
	}

	private Comment getCommentOrThrow(Long commentId){
		return commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException("없어"));
	}


}
