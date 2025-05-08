package com.example.todo.domain.comment.controller;

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

import com.example.todo.domain.comment.dto.request.CreateCommentRequestDto;
import com.example.todo.domain.comment.dto.request.UpdateCommentRequestDto;
import com.example.todo.domain.comment.dto.response.CreateCommentResponseDto;
import com.example.todo.domain.comment.dto.response.UpdateCommentResponseDto;
import com.example.todo.domain.comment.service.CommentService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@PostMapping
	public ResponseEntity<CreateCommentResponseDto> createComment(
		@Valid @RequestBody CreateCommentRequestDto createCommentRequestDto
	){
		CreateCommentResponseDto createComment = commentService.createComment(createCommentRequestDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(createComment);
	}

	@GetMapping
	public ResponseEntity<List<UpdateCommentResponseDto>> findAllComment(){
		List<UpdateCommentResponseDto> allComment = commentService.findAllComment();
		return ResponseEntity.ok(allComment);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UpdateCommentResponseDto> findByComment(@PathVariable Long id){
		UpdateCommentResponseDto findComment = commentService.findByComment(id);
		return ResponseEntity.ok(findComment);

	}

	@PatchMapping("/{id}")
	public ResponseEntity<UpdateCommentResponseDto> updateComment(
		@PathVariable Long id,
		@Valid @RequestBody UpdateCommentRequestDto updateCommentRequestDto
	){
		UpdateCommentResponseDto updateCommentResponseDto = commentService.updateComment(id, updateCommentRequestDto);
		return ResponseEntity.ok(updateCommentResponseDto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteComment(@PathVariable Long id){
		commentService.deleteComment(id);
		return ResponseEntity.noContent().build();
	}
}
