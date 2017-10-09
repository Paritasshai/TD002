package com.tamdai.model.course.dao;

import com.tamdai.model.course.entity.*;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

public interface CourseDao {

    Course createCourse(Long userId, Course course);

    Course getCourseId(Long id);

    Course updateCourse(Course course);

    CourseItem updateCourseItem(CourseItem courseItem);

    VideoClip saveVideo(VideoClip video);

    List<VideoClip> getVideoList();

    ImageCourse saveCourseImage(ImageCourse imageCourse);

    List<ImageCourse> getImageCurseList();

    List<VideoClip> getVideoCurseList();

    VideoClip getVideoClipsById(Long id);

    VideoClip updateVideoClips(VideoClip videoClip);

    List<Course> getCourseList();

    CourseItem createCourseVideoItem(CourseItem courseItem, Course course);

    CourseItem getCourseItemById(Long id);

    CourseItem createCourseImageItem(CourseItem courseItem, Course course);

    CourseItem courseItemId(Long id);

    ImageItem saveImage(ImageItem imageItem);

    List<ImageItem> getImageItemCourseList();

    Course deleteCourse(Course course);

    List<Course> courseItemByPublic(String textPublic);
}
