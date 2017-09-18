package com.tamdai.model.course.service;

import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.VideoClip;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */
public interface CourseService {

    Course addCourseDetail(UserEntity user, Course course);

    Course getCourseId(Long id);

    List<Course> getvideos();

    Course updateCourse(Course course);

    VideoClip saveVideo(VideoClip video, Course course);

    List<VideoClip> getVideoList();

    ImageCourse saveImage(Course course, ImageCourse imageCourse);

    List<ImageCourse> getImageCurseList();

    Course deleteImageCourse(Course course, Long imageId);

    Course deleteVideoCourse(Course course, Long videoId);
}
