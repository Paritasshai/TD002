package com.tamdai.model.course.repository;

import com.tamdai.model.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByPublicCourseContaining(String textPublic);
}
