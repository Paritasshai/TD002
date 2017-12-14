package com.tamdai.model.robomind.repository;

import com.tamdai.model.robomind.entity.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Long> {
    Content findByStStudentId(String stStudentId);
}
