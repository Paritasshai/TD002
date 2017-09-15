package com.tamdai.model.video.dao;

import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.video.entity.Course;
import com.tamdai.model.video.entity.VideoClip;

/**
 * Created by Film on 24/9/2559.
 */

public interface CourseDao {

    Course addVideo(UserEntity user, Course course);

    Course getCourseId(Long id);

    Course getListByName(String name);

    Course updateCourse(Course course);

    VideoClip videoClip(VideoClip video);
}
