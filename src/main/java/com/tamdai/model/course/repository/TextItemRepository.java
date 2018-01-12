package com.tamdai.model.course.repository;

import com.tamdai.model.course.entity.courseText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TextItemRepository extends JpaRepository<courseText, Long> {
}
