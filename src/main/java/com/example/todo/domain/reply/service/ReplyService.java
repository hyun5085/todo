package com.example.todo.domain.reply.service;

import org.springframework.stereotype.Service;

import com.example.todo.domain.comment.entity.Comment;
import com.example.todo.domain.comment.repository.CommentRepository;
import com.example.todo.domain.reply.dto.request.CreateReplyRequestDto;
import com.example.todo.domain.reply.dto.response.CreateReplyResponseDto;
import com.example.todo.domain.reply.dto.response.FindByReplyResponseDto;
import com.example.todo.domain.reply.dto.response.UpdateReplyResponseDto;
import com.example.todo.domain.reply.entity.Reply;
import com.example.todo.domain.reply.repository.ReplyRepository;
import com.example.todo.domain.todo.entity.Todo;
import com.example.todo.domain.todo.repository.TodoRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	private final ReplyRepository replyRepository;
	private final CommentRepository commentRepository;
	private final TodoRepository todoRepository;

	public CreateReplyResponseDto createReply (CreateReplyRequestDto createReplyRequestDto){
		Comment comment = getCommentOrThrow(createReplyRequestDto.getCommentId());
		Todo todo = getTodoOrThrow(comment.getTodo().getId());
		Reply reply = new Reply(createReplyRequestDto.getWriterId(),todo, comment, createReplyRequestDto.getContent());
		Reply createdReply = replyRepository.save(reply);
		return new CreateReplyResponseDto(
			createdReply.getId(),
			createdReply.getWriterId(),
			createdReply.getTodo().getId(),
			createdReply.getComment().getId(),
			createdReply.getContent(),
			createdReply.getCreatedAt()
		);
	}

	public FindByReplyResponseDto findByReply (Long id){
		Reply findReply = getReplyOrThrow(id);
		Comment comment = getCommentOrThrow(findReply.getComment().getId());
		UpdateReplyResponseDto replyResponseDto = new UpdateReplyResponseDto(
			findReply.getId(),
			findReply.getWriterId(),
			findReply.getTodo().getId(),
			findReply.getComment().getId(),
			findReply.getContent(),
			findReply.getCreatedAt(),
			findReply.getUpdatedAt()
		);

		return new FindByReplyResponseDto(
			comment.getId(),
			comment.getWriterId(),
			comment.getTodo().getId(),
			comment.getContent(),
			comment.getCreatedAt(),
			comment.getUpdatedAt(),
			replyResponseDto
		);

	}

	private Todo getTodoOrThrow(Long todoId){
		return todoRepository.findById(todoId).orElseThrow(()-> new IllegalArgumentException("없어"));
	}

	private Comment getCommentOrThrow(Long commentId){
		return commentRepository.findById(commentId).orElseThrow(()-> new IllegalArgumentException("없어"));
	}

	private Reply getReplyOrThrow(Long replyId){
		return replyRepository.findById(replyId).orElseThrow(()->new IllegalArgumentException("없어"));
	}
}
