package com.tamdai.model.video.service;

import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.video.dao.CourseDao;
import com.tamdai.model.video.entity.Course;
import com.tamdai.model.video.entity.VideoClip;
import com.tamdai.model.video.repository.VideoClipRepository;
import com.tamdai.model.video.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Film on 24/9/2559.
 */

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseDao courseDao;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VideoClipRepository videoClipRepository;

    @Override
    public Course addVideo(Course course) {
        return courseDao.addVideo(course);
    }

    @Override
    public Course getCourseId(Long id) {
        return courseDao.getCourseId(id);
    }

//    @Override
//    public Course addVideoClip(Course video, VideoClip videoClip) {
//        video.getVideoClips().add(videoClip);
//        ////courseRepository.save(video);
//        return courseRepository.save(video);
//    }

    @Override
    public List<Course> getvideos() {
        return courseRepository.findAll();
    }

    @Override
    public Course getListByName(String name) {
        return courseDao.getListByName(name);
    }

    @Override
    public Course updateCourse(Course course) {
        return courseDao.updateCourse(course);
    }

    @Override
    public List<VideoClip> getVideoClipList() {
        return videoClipRepository.findAll();
    }

    @Override
    public VideoClip addVideoClipObject(VideoClip video) {
        return courseDao.videoClip(video);
    }

}
