package com.tamdai.model.course.dao;

import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.course.repository.ImageCourseRepository;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.VideoClip;
import com.tamdai.model.course.repository.CourseRepository;
import com.tamdai.model.course.repository.VideoClipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    VideoClipRepository videoClipRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageCourseRepository imageCourseRepository;

    @Override
    public Course addCourseDetail(UserEntity user, Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseId(Long id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public VideoClip saveVideo(VideoClip video) {
        return videoClipRepository.save(video);
    }

    @Override
    public List<VideoClip> getVideoList() {
        return videoClipRepository.findAll();
    }

    @Override
    public ImageCourse saveImage(ImageCourse imageCourse) {
        return imageCourseRepository.save(imageCourse);
    }

    @Override
    public List<ImageCourse> getImageCurseList() {
        return imageCourseRepository.findAll();
    }

}
