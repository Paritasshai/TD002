package com.tamdai.model.robomind.service;

import com.tamdai.model.robomind.dao.RobomindDao;
import com.tamdai.model.robomind.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
public class RobomindServiceImp implements RobomindService {

    @Autowired
    RobomindDao robomindDao;

    @Override
    public StudentProfile createProfile(StudentProfile stProfile) {
        return robomindDao.createProfile(stProfile);
    }

    @Override
    public Robotic roboticDelete(Robotic robotic) {
        return robomindDao.roboticDelete(robotic);
    }

    @Override
    public Robotic getRoboticId(Long id) {
        return robomindDao.getRoboticId(id);
    }

    @Override
    public Robotic createRoboticName(Robotic robotic) {
        return robomindDao.createRoboticName(robotic);
    }

    @Override
    public List<Robotic> RoboticNameList() {
        return robomindDao.RoboticNameList();
    }

    @Override
    public List<StudentProfile> getStudentList() {
        return robomindDao.getStudentList();
    }

    @Override
    public StudentProfile getStudentId(Long id) {
        return robomindDao.getStudentId(id);
    }

    @Override
    public StudentProfile saveStudentImage(StudentProfile studentProfile, RoboImage roboImage) {
        studentProfile.getRoboImageSet().add(roboImage);
        robomindDao.saveStudentImage(roboImage);
        return robomindDao.updateProfile(studentProfile);
    }

    @Override
    public StudentProfile editProfile(StudentProfile student) {
        return robomindDao.editProfile(student);
    }

    @Override
    public StudentProfile getStudentStid(String stId) {
        return robomindDao.getStudentStid(stId);
    }

    @Override
    public StudentProfile deleteImageStudent(StudentProfile student, Long imageId) {
        Set<RoboImage> roboImageSet = student.getRoboImageSet();
        for (Iterator<RoboImage> it = roboImageSet.iterator(); it.hasNext(); ) {
            RoboImage f = it.next();
            if (f.getId().equals(imageId)) {
                student.getRoboImageSet().remove(f);
            }
        }

        robomindDao.updateProfile(student);
        return student;
    }

    @Override
    public StudentProfile addContent(StudentProfile student, Content content) {
        student.getContents().add(content);

        //setContentDate
//        String ContentDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
//        content.setContentDate(ContentDate);

        robomindDao.addContent(content);
        return robomindDao.updateProfile(student);
    }

    @Override
    public Content getContent(Long id) {
        return robomindDao.getContent(id);
    }

    @Override
    public Content addImageContent(Content content, ContentImg contentImg) {
        content.getContentImgs().add(contentImg);
        robomindDao.saveImageContent(contentImg);
        return robomindDao.updateContent(content);
    }

    @Override
    public List<Content> getContentList() {
        return robomindDao.getContentList();
    }


    @Override
    public ContentImg getImageContent(Long id) {
        return robomindDao.getImageContent(id);
    }

    @Override
    public Content getContentStStudentId(String stStudentId) {
        return robomindDao.stStudentId(stStudentId);
    }

    @Override
    public Content deleteImageContent(Content content, Long imageId) {
        Set<ContentImg> contentImgs = content.getContentImgs();
        for (Iterator<ContentImg> it = contentImgs.iterator(); it.hasNext(); ) {
            ContentImg f = it.next();
            if (f.getId().equals(imageId)) {
                content.getContentImgs().remove(f);
            }
        }

        robomindDao.updateContent(content);
        return content;
    }

    @Override
    public StudentProfile deleteProfile(Long studentId) {
        StudentProfile studentProfile = getStudentId(studentId);
        return robomindDao.deleteProfile(studentProfile);
    }

    @Override
    public StudentProfile getStudentBySearch(String username, String date) {
        return robomindDao.getStudentBySearch(username, date);
    }

    @Override
    public Content editContent(Content content) {
        return robomindDao.editContent(content);
    }

    @Override
    public Comment createComment(Comment comment, StudentProfile studentProfile) {
//
        robomindDao.updateProfile(studentProfile);
        robomindDao.createComment(comment);
        return comment;
    }

    @Override
    public StudentProfile deleteContent(Long id, StudentProfile studentProfile) {
        Set<Content> contents = studentProfile.getContents();
        for (Iterator<Content> it = contents.iterator(); it.hasNext(); ) {
            Content f = it.next();
            if (f.getId().equals(id)) {
                studentProfile.getContents().remove(f);
            }
        }
        robomindDao.updateProfile(studentProfile);
        robomindDao.deleteContent(id);
        return studentProfile;
    }

    @Override
    public List<Robotic> getSearchGroup(String name) {
        return robomindDao.getSearchGroup(name);
    }

}