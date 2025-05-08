package com.example.todo.domain.comment.service;

import org.springframework.stereotype.Service;

import com.example.todo.domain.comment.repository.CommentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
}
