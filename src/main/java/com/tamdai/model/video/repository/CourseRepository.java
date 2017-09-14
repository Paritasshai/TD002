package com.tamdai.model.video.repository;

import com.tamdai.model.video.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 2/9/2015.
 */

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
}
