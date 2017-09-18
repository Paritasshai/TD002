package com.tamdai.model.course.service;

import com.tamdai.model.course.entity.ImageCourse;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.course.dao.CourseDao;
import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.VideoClip;
import com.tamdai.model.course.repository.VideoClipRepository;
import com.tamdai.model.course.repository.CourseRepository;
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
    CourseRepository courseRepository;

    @Override
    public Course addCourseDetail(UserEntity user, Course course) {
        course.getUsers().add(user);
        return courseDao.addCourseDetail(user, course);
    }

    @Override
    public Course getCourseId(Long id) {
        return courseDao.getCourseId(id);
    }

    @Override
    public List<Course> getvideos() {
        return courseRepository.findAll();
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public VideoClip saveVideo(VideoClip video, Course course) {
        course.getVideoClips().add(video);
        courseDao.updateCourse(course);
        return courseDao.saveVideo(video);
    }

    @Override
    public List<VideoClip> getVideoList() {
        return courseDao.getVideoList();
    }

    @Override
    public ImageCourse saveImage(Course course, ImageCourse imageCourse) {
        course.getImageCourses().add(imageCourse);
        courseDao.updateCourse(course);
        return courseDao.saveImage(imageCourse);
    }

    @Override
    public List<ImageCourse> getImageCurseList() {
        return courseDao.getImageCurseList();
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

    @Override
    public Course deleteVideoCourse(Course course, Long videoId) {
        Set<VideoClip> videoClips = course.getVideoClips();
        VideoClip removeVideo = null;
        for (Iterator<VideoClip> it = videoClips.iterator(); it.hasNext(); ) {
            VideoClip i = it.next();
            if (i.getId().equals(videoId)) {
                removeVideo = i;
                break;
            }
        }

        videoClips.remove(removeVideo);
        courseDao.updateCourse(course);
        return course;
    }

}
