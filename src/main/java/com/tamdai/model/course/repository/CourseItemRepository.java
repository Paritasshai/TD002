package com.tamdai.model.course.repository;

import com.tamdai.model.course.entity.CourseItem;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Dto on 2/9/2015.
 */

public interface CourseItemRepository extends JpaRepository<CourseItem, Long> {

}
