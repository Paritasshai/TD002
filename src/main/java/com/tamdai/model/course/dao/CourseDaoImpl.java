package com.tamdai.model.course.dao;

import com.tamdai.model.course.entity.*;
import com.tamdai.model.course.repository.*;
import com.tamdai.model.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@Repository
public class CourseDaoImpl implements CourseDao {

    @Autowired
    CourseItemRepository courseItemRepository;

    @Autowired
    VideoClipRepository videoClipRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ImageCourseRepository imageCourseRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    ImageItemRepository imageItemRepository;

    @Override
    public Course createCourse(Long userId, Course course) {
        course.setUserId(userId);
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
    public CourseItem updateCourseItem(CourseItem courseItem) {
        return courseItemRepository.save(courseItem);
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
    public ImageCourse saveCourseImage(ImageCourse imageCourse) {
        return imageCourseRepository.save(imageCourse);
    }

    @Override
    public List<ImageCourse> getImageCurseList() {
        return imageCourseRepository.findAll();
    }

    @Override
    public List<VideoClip> getVideoCurseList() {
        return videoClipRepository.findAll();
    }

    @Override
    public VideoClip getVideoClipsById(Long id) {
        return videoClipRepository.findOne(id);
    }

    @Override
    public VideoClip updateVideoClips(VideoClip videoClip) {
        return videoClipRepository.save(videoClip);
    }

    @Override
    public List<Course> getCourseList() {
        return courseRepository.findAll();
    }

    @Override
    public CourseItem createCourseVideoItem(CourseItem courseItem, Course course) {
        course.getCourseItems().add(courseItem);
        courseRepository.save(course);
        return courseItemRepository.save(courseItem);
    }

    @Override
    public CourseItem getCourseItemById(Long id) {
        return courseItemRepository.findOne(id);
    }

    @Override
    public CourseItem createCourseImageItem(CourseItem courseItem, Course course) {
        course.getCourseItems().add(courseItem);
        courseRepository.save(course);
        return courseItemRepository.save(courseItem);
    }

    @Override
    public CourseItem courseItemId(Long id) {
        return courseItemRepository.findOne(id);
    }

    @Override
    public ImageItem saveImage(ImageItem imageItem) {
        return imageItemRepository.save(imageItem);
    }

    @Override
    public List<ImageItem> getImageItemCourseList() {
        return imageItemRepository.findAll();
    }

    @Override
    public Course deleteCourse(Course course) {
        courseRepository.delete(course);
        course.setId(null);
        return course;
    }

    @Override
    public List<Course> courseItemByPublic(String textPublic) {
        return courseRepository.findByPublicCourseContaining(textPublic);
    }

    @Override
    public List<Course> getCoursenewType(String textPublic, String newType) {
        return courseRepository.findByPublicCourseAndCourseTypeContaining(textPublic, newType);
    }

    @Override
    public List<Course> getCourserecommendType(String textPublic, String recommendType) {
        return courseRepository.findByPublicCourseAndCourseTypeContaining(textPublic, recommendType);
    }

    @Override
    public List<Course> getCourseHotType(String textPublic, String hotType) {
        return courseRepository.findByPublicCourseAndCourseTypeContaining(textPublic, hotType);
    }

    @Override
    public Course getCourseByUser(Long courseId) {
        return courseRepository.findOne(courseId);
    }

    @Override
    public List<Course> getCourseLego(String textPublic, String legoText) {
        return courseRepository.findByPublicCourseAndCatagoryContaining(textPublic, legoText);
    }

    @Override
    public List<Course> getCourseHousehold(String textPublic, String householdText) {
        return courseRepository.findByPublicCourseAndCatagoryContaining(textPublic, householdText);
    }

    @Override
    public List<Course> getCourseToy(String textPublic, String toyText) {
        return courseRepository.findByPublicCourseAndCatagoryContaining(textPublic, toyText);
    }

    @Override
    public List<Course> getCourseGarden(String textPublic, String gardenText) {
        return courseRepository.findByPublicCourseAndCatagoryContaining(textPublic, gardenText);
    }

    @Override
    public List<Course> getCourseIoT(String textPublic, String ioTText) {
        return courseRepository.findByPublicCourseAndCatagoryContaining(textPublic, ioTText);
    }

    @Override
    public List<Course> getSearchByName(String textPublic, String querySearch) {
        return courseRepository.findByPublicCourseAndNameContainingIgnoreCase(textPublic, querySearch);
    }

    @Override
    public CourseItem createCourseTextItem(CourseItem courseItem, Course course) {
        course.getCourseItems().add(courseItem);
        courseRepository.save(course);
        return courseItemRepository.save(courseItem);
    }

    @Override
    public List<Course> getsearchAdvance(String textPublic, String pname) {
        return courseRepository.findByPublicCourseAndNameContainingIgnoreCase(textPublic, pname);
    }

    @Override
    public List<Course> getSearchByFree(String textPublic, String empty) {
        return courseRepository.findByPublicCourseAndPriceContainingIgnoreCase(textPublic, empty);
    }

    @Override
    public List<Course> getCourseByUserId(String textPublic, Long id) {
        return courseRepository.findByPublicCourseAndUserId(textPublic, id);
    }

    @Override
    public List<Course> getSearchObject(String pname, String textPublic, String textNull, String rbGroup) {
        return courseRepository.findByNameContainingIgnoreCaseAndPublicCourseAndPriceContainingIgnoreCaseAndCatagory(pname, textPublic, textNull, rbGroup);
    }

    @Override
    public List<Course> getSearchObjectPay(String pname, String textPublic, String textNull, String rbGroup) {
        return courseRepository.findByNameContainingIgnoreCaseAndPublicCourseAndPriceNotContainingIgnoreCaseAndCatagory(pname, textPublic, textNull, rbGroup);
    }

    @Override
    public List<Course> getSearchObjectFreePname(String pname, String textPublic, String textNull) {
        return courseRepository.findByNameContainingIgnoreCaseAndPublicCourseAndPriceContainingIgnoreCase(pname, textPublic, textNull);
    }

}
