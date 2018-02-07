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

    List<Course> getCoursenewType(String textPublic, String newType);

    List<Course> getCourserecommendType(String textPublic, String recommendType);

    List<Course> getCourseHotType(String textPublic, String hotType);

    Course getCourseByUser(Long courseId);

    List<Course> getCourseLego(String textPublic, String legoText);

    List<Course> getCourseHousehold(String textPublic, String householdText);

    List<Course> getCourseToy(String textPublic, String toyText);

    List<Course> getCourseGarden(String textPublic, String gardenText);

    List<Course> getCourseIoT(String textPublic, String ioTText);

    List<Course> getSearchByName(String textPublic, String querySearch);

    CourseItem createCourseTextItem(CourseItem courseItem, Course course);

    List<Course> getsearchAdvance(String textPublic, String pname);

    List<Course> getSearchByFree(String textPublic, String empty);

    List<Course> getCourseByUserId(String textPublic, Long id);

    List<Course> getSearchObject(String pname, String textPublic, String textNull, String rbGroup);

    List<Course> getSearchObjectPay(String textPublic, String textNull);

    List<Course> getSearchObjectFreePname(String pname, String textPublic, String textNull);

	List<Course> getSearchByDate(String startDate, String endDate, String textPublic);

}
