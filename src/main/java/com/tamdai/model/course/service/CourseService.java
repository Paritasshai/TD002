package com.tamdai.model.course.service;

import com.tamdai.model.course.entity.*;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */
public interface CourseService {

    Course createCourse(UserEntity user, Course course);

    Course getCourseId(Long id);

    List<CourseItem> getCourseItemList();

    Course updateCourse(Course course);

    VideoClip saveVideo(VideoClip video, CourseItem courseItem);

    List<VideoClip> getVideoList();

    ImageCourse saveCourseImage(Course course, ImageCourse imageCourse);

    List<ImageCourse> getImageCourseList();

    Course deleteImageCourse(Course course, Long imageId);

    CourseItem deleteVideoCourse(CourseItem courseItem, Long videoId);

    List<VideoClip> getVideoCourseList();

    VideoClip getVideoClipsById(Long id);

    VideoClip updateVideoClips(VideoClip videoClip);

    List<Course> getCourseList();

    CourseItem createCourseVideoItem(CourseItem courseItem, Course course);

    CourseItem getCourseItemtemById(Long id);

    CourseItem createCourseImageItem(CourseItem courseItem, Course course);

    CourseItem courseItemId(Long id);

    CourseItem updateCourseItem(CourseItem courseItem);

    ImageItem saveCourseImageItem(CourseItem courseItem, ImageItem imageItem);

    List<ImageItem> getImageItemCourseList();
}
