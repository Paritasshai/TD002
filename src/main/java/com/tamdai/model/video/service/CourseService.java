package com.tamdai.model.video.service;

import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.video.entity.Course;
import com.tamdai.model.video.entity.VideoClip;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */
public interface CourseService {

    Course addVideo(UserEntity user, Course course);

    Course getCourseId(Long id);

//    Course addVideoClip(Course video, VideoClip videoClip);

    List<Course> getvideos();

    Course getListByName(String name);

    Course updateCourse(Course course);

    List<VideoClip> getVideoClipList();

    VideoClip addVideoClipObject(VideoClip videoClip);
}
