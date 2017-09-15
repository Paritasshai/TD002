package com.tamdai.model.video.dao;

import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.video.entity.Course;
import com.tamdai.model.video.entity.VideoClip;
import com.tamdai.model.video.repository.CourseRepository;
import com.tamdai.model.video.repository.VideoClipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    @Override
    public Course addVideo(UserEntity user, Course course) {
        user.getCourses().add(course);
        userRepository.save(user);
        return course;
    }

    @Override
    public Course getCourseId(Long id) {
        return courseRepository.findOne(id);
    }

    @Override
    public Course getListByName(String name) {
        return courseRepository.findByName(name);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public VideoClip videoClip(VideoClip video) {
        return videoClipRepository.save(video);
    }

}
