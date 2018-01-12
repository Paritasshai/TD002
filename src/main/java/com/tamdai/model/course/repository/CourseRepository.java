package com.tamdai.model.course.repository;

import com.tamdai.model.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByPublicCourseContaining(String textPublic);

    List<Course> findByPublicCourseAndCourseTypeContaining(String textPublic, String newType);

    List<Course> findByPublicCourseAndCatagoryContaining(String textPublic, String legoText);

    List<Course> findByPublicCourseAndNameContainingIgnoreCase(String textPublic, String querySearch);

    List<Course> findByPublicCourseAndPriceContainingIgnoreCase(String textPublic, String empty);

    List<Course> findByPublicCourseAndUserId(String textPublic, Long id);

    List<Course> findByNameContainingIgnoreCaseAndPublicCourseAndPriceContainingIgnoreCaseAndCatagory(String pname, String textPublic, String textNull, String rbGroup);

    List<Course> findByNameContainingIgnoreCaseAndPublicCourseAndPriceNotContainingIgnoreCaseAndCatagory(String pname, String textPublic, String textNull, String rbGroup);

    List<Course> findByNameContainingIgnoreCaseAndPublicCourseAndPriceContainingIgnoreCase(String pname, String textPublic, String textNull);


//    List<Course> findByPublicCourseAndCourseTypeContaining(String textPublic, String newType);
//    List<Course> findByPublicCourseAndCourseTypeContaining(String textPublic, String recommendType);
}
