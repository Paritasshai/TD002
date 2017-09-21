package com.tamdai.model.course.dao;

import com.tamdai.model.course.entity.*;
import com.tamdai.model.course.repository.*;
import com.tamdai.model.security.entity.UserEntity;
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
    public Course createCourse(UserEntity user, Course course) {
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
    public CourseItem getCourseItemtemById(Long id) {
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

}
