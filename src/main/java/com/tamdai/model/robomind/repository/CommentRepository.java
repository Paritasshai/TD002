package com.tamdai.model.robomind.repository;

import com.tamdai.model.robomind.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
