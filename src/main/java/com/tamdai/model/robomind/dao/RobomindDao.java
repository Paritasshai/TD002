package com.tamdai.model.robomind.dao;

import com.tamdai.model.robomind.entity.*;

import java.util.List;

public interface RobomindDao {
    StudentProfile createProfile(StudentProfile stProfile);

    List<StudentProfile> getStudentList();

    StudentProfile getStudentId(Long id);

    RoboImage saveStudentImage(RoboImage roboImage);

    StudentProfile updateProfile(StudentProfile studentProfile);

    StudentProfile editProfile(StudentProfile student);

    StudentProfile getStudentStid(String stId);

    Content addContent(Content content);

    Content getContent(Long id);

    ContentImg saveImageContent(ContentImg contentImg);

    Content updateContent(Content content);

    List<Content> getContentList();

    ContentImg getImageContent(Long id);

    Content stStudentId(String stStudentId);

    StudentProfile deleteProfile(StudentProfile studentProfile);

    StudentProfile getStudentBySearch(String username, String date);

    Content editContent(Content content);

    Comment createComment(Comment comment);

    Content deleteContent(Long id);

    Robotic createRoboticName(Robotic robotic);

    List<Robotic> RoboticNameList();

    Robotic getRoboticId(Long id);

    Robotic roboticDelete(Robotic robotic);

    List<Robotic> getSearchGroup(String name);

}
