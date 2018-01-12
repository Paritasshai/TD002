package com.tamdai.model.robomind.dao;

import com.tamdai.model.robomind.entity.*;
import com.tamdai.model.robomind.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class RobomindDaoImp implements RobomindDao {

    @Autowired
    RobomindRepository robomindRepository;

    @Autowired
    RoboImageRepository roboImageRepository;

    @Autowired
    ContentRepository contentRepository;

    @Autowired
    ContentImgRepository contentImgRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    RoboticRepository roboticRepository;

    @Override
    public StudentProfile createProfile(StudentProfile stProfile) {
        return robomindRepository.save(stProfile);
    }

    @Override
    public Robotic getRoboticId(Long id) {
        return roboticRepository.findOne(id);
    }

    @Override
    public Robotic createRoboticName(Robotic robotic) {
        return roboticRepository.save(robotic);
    }

    @Override
    public List<Robotic> RoboticNameList() {
        return roboticRepository.findAll();
    }

    @Override
    public List<StudentProfile> getStudentList() {
        return robomindRepository.findAll();
    }

    @Override
    public StudentProfile getStudentId(Long id) {
        return robomindRepository.findOne(id);
    }

    @Override
    public RoboImage saveStudentImage(RoboImage roboImage) {
        return roboImageRepository.save(roboImage);
    }

    @Override
    public StudentProfile updateProfile(StudentProfile studentProfile) {
        return robomindRepository.save(studentProfile);
    }

    @Override
    public StudentProfile editProfile(StudentProfile student) {
        return robomindRepository.save(student);
    }

    @Override
    public StudentProfile getStudentStid(String stId) {
        return robomindRepository.findByStId(stId);
    }

    @Override
    public Content addContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Content getContent(Long id) {
        return contentRepository.findOne(id);
    }

    @Override
    public ContentImg saveImageContent(ContentImg contentImg) {
        return contentImgRepository.save(contentImg);
    }

    @Override
    public Content updateContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public List<Content> getContentList() {
        return contentRepository.findAll();
    }

    @Override
    public ContentImg getImageContent(Long id) {
        return contentImgRepository.findOne(id);
    }

    @Override
    public Content stStudentId(String stStudentId) {
        return contentRepository.findByStStudentId(stStudentId);
    }

    @Override
    public StudentProfile deleteProfile(StudentProfile studentProfile) {
        robomindRepository.delete(studentProfile);
//        studentProfile.setId("null");
        return studentProfile;
    }

    @Override
    public Robotic roboticDelete(Robotic robotic) {
        roboticRepository.delete(robotic);
        return robotic;
    }

    @Override
    public StudentProfile getStudentBySearch(String username, String date) {
        return robomindRepository.findByStFirstnameAndStDateContainingAllIgnoreCase(username, date);
    }

    @Override
    public Content editContent(Content content) {
        return contentRepository.save(content);
    }

    @Override
    public Comment createComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Content deleteContent(Long id) {
        Content content = getContent(id);
        //content.setId(null);
        contentRepository.delete(content);
        return content;
    }

    @Override
    public List<Robotic> getSearchGroup(String name) {
        return roboticRepository.findByNameGroupContaining(name);
    }

}
