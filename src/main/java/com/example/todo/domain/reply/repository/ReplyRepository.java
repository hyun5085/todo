package com.example.todo.domain.reply.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.todo.domain.reply.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
