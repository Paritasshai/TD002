package com.tamdai.model.robomind.service;

import com.tamdai.model.robomind.entity.*;

import java.util.List;

public interface RobomindService {
    StudentProfile createProfile(StudentProfile stProfile);

    List<StudentProfile> getStudentList();

    StudentProfile getStudentId(Long id);

    StudentProfile saveStudentImage(StudentProfile studentProfile, RoboImage roboImage);

    StudentProfile editProfile(StudentProfile student);

    StudentProfile getStudentStid(String stId);

    StudentProfile deleteImageStudent(StudentProfile student, Long imageId);

    StudentProfile addContent(StudentProfile student, Content content);

    Content getContent(Long id);

    Content addImageContent(Content content, ContentImg contentImg);

    List<Content> getContentList();

    ContentImg getImageContent(Long id);

    Content getContentStStudentId(String stStudentId);

    Content deleteImageContent(Content content, Long imageId);

    StudentProfile deleteProfile(Long studentId);

    StudentProfile getStudentBySearch(String username, String date);

    Content editContent(Content content);

    Comment createComment(Comment comment, StudentProfile studentProfile);

    StudentProfile deleteContent(Long id, StudentProfile studentProfile);

    Robotic createRoboticName(Robotic robotic);

    List<Robotic> RoboticNameList();

    Robotic getRoboticId(Long id);

    Robotic roboticDelete(Robotic robotic);

    List<Robotic> getSearchGroup(String name);

}
