package com.example.todo.domain.reply.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.todo.domain.reply.dto.request.CreateReplyRequestDto;
import com.example.todo.domain.reply.dto.response.CreateReplyResponseDto;
import com.example.todo.domain.reply.dto.response.FindByReplyResponseDto;
import com.example.todo.domain.reply.service.ReplyService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/replies")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService replyService;

	@PostMapping
	public ResponseEntity<CreateReplyResponseDto> createReply (
		@Valid @RequestBody CreateReplyRequestDto createReplyRequestDto){
		CreateReplyResponseDto createReply = replyService.createReply(createReplyRequestDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createReply);
	}

	@GetMapping("/{id}")
	public ResponseEntity<FindByReplyResponseDto> findReply(@PathVariable Long id){
		FindByReplyResponseDto byReply = replyService.findByReply(id);
		return ResponseEntity.ok(byReply);
	}
}
