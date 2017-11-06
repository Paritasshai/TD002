package com.tamdai.model.course.service;

import com.tamdai.model.course.entity.*;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */
public interface CourseService {

    Course createCourse(Long userId, Course course);

    Course getCourseId(Long id);

    List<CourseItem> getCourseItemList();

    Course updateCourse(Course course);

    VideoClip saveVideo(VideoClip video, CourseItem courseItem);

    List<VideoClip> getVideoList();

//    ImageCourse saveCourseImage(Course course, ImageCourse imageCourse);

//    List<ImageCourse> getImageCourseList();

    CourseItem deleteVideoCourse(CourseItem courseItem, Long videoId);

    List<VideoClip> getVideoCourseList();

    VideoClip getVideoClipsById(Long id);

    VideoClip updateVideoClips(VideoClip videoClip);

    List<Course> getCourseList();

    CourseItem createCourseVideoItem(CourseItem courseItem, Course course);

    CourseItem getCourseItemById(Long id);

    CourseItem createCourseImageItem(CourseItem courseItem, Course course);

    CourseItem courseItemId(Long id);

    CourseItem updateCourseItem(CourseItem courseItem);

    ImageItem saveCourseImageItem(CourseItem courseItem, ImageItem imageItem);

    List<ImageItem> getImageItemCourseList();

    Course deleteCourse(Long id);

    List<Course> courseItemByPublic(String textPublic);

    Course deleteItem(Course course, Long courseItem);

    List<Course> getCoursenewType(String textPublic, String newType);

    List<Course> getCourserecommendType(String textPublic, String recommendType);

    List<Course> getCourseHotType(String textPublic, String hotType);

    Course getCourseByUser(Long courseId, Long userId);

//    Course deleteImageCourse(Course course, Long imageId);

    Course addImageCourse(Course course, CourseImage courseImage);

    Course deleteImage(Course course, Long imageId);

    List<Course> getCourseLego(String textPublic, String legoText);

    List<Course> getCourseHousehold(String textPublic, String householdText);

    List<Course> getCourseToy(String textPublic, String toyText);

    List<Course> getCourseGarden(String textPublic, String gardenText);

    List<Course> getCourseIoT(String textPublic, String ioTText);

    List<Course> getSearchByName(String textPublic, String querySearch);
}
