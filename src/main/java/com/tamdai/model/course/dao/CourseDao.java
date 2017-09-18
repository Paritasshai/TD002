package com.tamdai.model.course.dao;

import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.VideoClip;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

public interface CourseDao {

    Course addCourseDetail(UserEntity user, Course course);

    Course getCourseId(Long id);

    Course updateCourse(Course course);

    VideoClip saveVideo(VideoClip video);

    List<VideoClip> getVideoList();

    ImageCourse saveImage(ImageCourse imageCourse);

    List<ImageCourse> getImageCurseList();
}
