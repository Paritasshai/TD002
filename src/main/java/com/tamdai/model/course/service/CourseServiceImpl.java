package com.tamdai.model.course.service;

import com.tamdai.model.course.entity.*;
import com.tamdai.model.course.repository.CourseRepository;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.course.dao.CourseDao;
import com.tamdai.model.course.repository.VideoClipRepository;
import com.tamdai.model.course.repository.CourseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course createCourse(Long userId, Course course) {
        return courseDao.createCourse(userId, course);
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

//    @Override
//    public ImageCourse saveCourseImage(Course course, ImageCourse imageCourse) {
//        course.getImageCourses().add(imageCourse);
//        courseDao.updateCourse(course);
//        return courseDao.saveCourseImage(imageCourse);
//    }

    @Override
    public List<ImageCourse> getImageCourseList() {
        return courseDao.getImageCurseList();
    }

    @Override
    public CourseItem deleteVideoCourse(CourseItem courseItem, Long videoId) {
        return null;
    }

    @Override
    public Course deleteItem(Course course, Long courseItem) {
        Set<CourseItem> courseItems = course.getCourseItems();
        for (Iterator<CourseItem> it = courseItems.iterator(); it.hasNext(); ) {
            CourseItem f = it.next();
            if (f.getId().equals(courseItem)) {
                course.getCourseItems().remove(f);
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
        courseItem.setName("Lesson Name");
        courseItem.setDescription("Lesson Description");
        courseItem.setCanPreview("false");

        courseDao.createCourseVideoItem(courseItem, course);
        return courseItem;
    }

    @Override
    public CourseItem createCourseImageItem(CourseItem courseItem, Course course) {

        //setItemType
        String type = new String("image");
        courseItem.setName("Lesson Name");
        courseItem.setDescription("Lesson Description");
        courseItem.setCourseType(type);
        courseItem.setCanPreview("false");

        courseDao.createCourseImageItem(courseItem, course);
        return courseItem;
    }

    @Override
    public CourseItem getCourseItemById(Long id) {
        return courseDao.getCourseItemById(id);
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

    @Override
    public Course deleteCourse(Long id) {
        Course course = getCourseId(id);
        return courseDao.deleteCourse(course);
    }

    @Override
    public List<Course> courseItemByPublic(String textPublic) {
        return courseDao.courseItemByPublic(textPublic);
    }

    @Override
    public List<Course> getCoursenewType(String textPublic, String newType) {
        return courseDao.getCoursenewType(textPublic, newType);
    }

    @Override
    public List<Course> getCourserecommendType(String textPublic, String recommendType) {
        return courseDao.getCourserecommendType(textPublic, recommendType);
    }

    @Override
    public List<Course> getCourseHotType(String textPublic, String hotType) {
        return courseDao.getCourseHotType(textPublic, hotType);
    }

    @Override
    public Course getCourseByUser(Long courseId, Long userId) {
        UserEntity users = userRepository.getOne(userId);
        boolean isFind = false;
        for (Course course : users.getCourses()) {
            if (course.getId().equals(courseId)) {
                isFind = true;
                break;
            }
        }

        if (!isFind) return null;
        return courseDao.getCourseId(courseId);
    }

//    @Override
//    public Course deleteImageCourse(Course course, Long imageId) {
//        Set<ImageCourse> images = course.getImageCourses();
//        for (Iterator<ImageCourse> it = images.iterator(); it.hasNext(); ) {
//            ImageCourse f = it.next();
//            if (f.getId().equals(imageId)) {
//                course.getImageCourses().remove(f);
//            }
//        }
//
//        courseDao.updateCourse(course);
//        return course;
//    }

    @Override
    @Transactional
    public Course addImageCourse(Course course, CourseImage courseImage) {
        courseImage = CourseImageUtil.resizeImage(courseImage, 300);
        course.getCourseImages().add(courseImage);
        courseDao.updateCourse(course);
        return course;
    }

    @Override
    public Course deleteImage(Course course, Long imageId) {
        Set<CourseImage> courseImages = course.getCourseImages();
        for (Iterator<CourseImage> it = courseImages.iterator(); it.hasNext(); ) {
            CourseImage f = it.next();
            if (f.getId().equals(imageId)) {
                course.getCourseImages().remove(f);
            }
        }

        courseDao.updateCourse(course);
        return course;
    }


}
