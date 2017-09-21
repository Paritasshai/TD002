package com.tamdai.model.course.service;

import com.tamdai.model.course.entity.*;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.course.dao.CourseDao;
import com.tamdai.model.course.repository.VideoClipRepository;
import com.tamdai.model.course.repository.CourseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Film on 24/9/2559.
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VideoClipRepository videoClipRepository;

    @Autowired
    CourseItemRepository courseItemRepository;

    @Override
    public Course createCourse(UserEntity user, Course course) {
        course.getUsers().add(user);
        return courseDao.createCourse(user, course);
    }

    @Override
    public Course getCourseId(Long id) {
        return courseDao.getCourseId(id);
    }

    @Override
    public List<CourseItem> getCourseItemList() {
        return courseItemRepository.findAll();
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public VideoClip saveVideo(VideoClip video, CourseItem courseItem) {
        courseItem.getVideoClips().add(video);
        courseDao.updateCourseItem(courseItem);

        return courseDao.saveVideo(video);
    }

    @Override
    public List<VideoClip> getVideoList() {
        return courseDao.getVideoList();
    }

    @Override
    public ImageCourse saveCourseImage(Course course, ImageCourse imageCourse) {
        course.getImageCourses().add(imageCourse);
        courseDao.updateCourse(course);
        return courseDao.saveCourseImage(imageCourse);
    }

    @Override
    public List<ImageCourse> getImageCourseList() {
        return courseDao.getImageCurseList();
    }

    @Override
    public CourseItem deleteVideoCourse(CourseItem courseItem, Long videoId) {
        return null;
    }

    @Override
    public Course deleteImageCourse(Course course, Long imageId) {
        Set<ImageCourse> images = course.getImageCourses();
        for (Iterator<ImageCourse> it = images.iterator(); it.hasNext(); ) {
            ImageCourse f = it.next();
            if (f.getId().equals(imageId)) {
                course.getImageCourses().remove(f);
            }
        }

        courseDao.updateCourse(course);
        return course;
    }

//    @Override
//    public CourseItem deleteVideoCourse(CourseItem courseItem, Long videoId) {
//        Set<VideoClip> videoClips = courseItem.getVideoClips();
//        VideoClip removeVideo = null;
//        for (Iterator<VideoClip> it = videoClips.iterator(); it.hasNext(); ) {
//            VideoClip i = it.next();
//            if (i.getId().equals(videoId)) {
//                removeVideo = i;
//                break;
//            }
//        }
//
//        videoClips.remove(removeVideo);
//        courseDao.updateCourse(courseItem);
//        return courseItem;
//    }

    @Override
    public List<VideoClip> getVideoCourseList() {
        return courseDao.getVideoCurseList();
    }

    @Override
    public VideoClip getVideoClipsById(Long id) {
        return courseDao.getVideoClipsById(id);
    }

    @Override
    public VideoClip updateVideoClips(VideoClip videoClip) {
        return courseDao.updateVideoClips(videoClip);
    }

    @Override
    public List<Course> getCourseList() {
        return courseDao.getCourseList();
    }

    @Override
    public CourseItem createCourseVideoItem(CourseItem courseItem, Course course) {
        //setItemType
        String type = new String("video");
        courseItem.setCourseType(type);
        courseDao.createCourseVideoItem(courseItem, course);
        return courseItem;
    }

    @Override
    public CourseItem getCourseItemtemById(Long id) {
        return courseDao.getCourseItemtemById(id);
    }

    @Override
    public CourseItem createCourseImageItem(CourseItem courseItem, Course course) {

        //setItemType
        String type = new String("image");
        courseItem.setCourseType(type);

        courseDao.createCourseImageItem(courseItem, course);
        return courseItem;
    }

    @Override
    public CourseItem courseItemId(Long id) {
        return courseDao.courseItemId(id);
    }

    @Override
    public CourseItem updateCourseItem(CourseItem courseItem) {
        return courseDao.updateCourseItem(courseItem);
    }

    @Override
    public ImageItem saveCourseImageItem(CourseItem courseItem, ImageItem imageItem) {
        courseItem.getImageItems().add(imageItem);
        courseDao.updateCourseItem(courseItem);
        return courseDao.saveImage(imageItem);
    }

    @Override
    public List<ImageItem> getImageItemCourseList() {
        return courseDao.getImageItemCourseList();
    }

}
