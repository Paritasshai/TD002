package com.tamdai.model.security.service;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.security.entity.Lists;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.entity.UserImage;

import java.util.List;

public interface UserService {

    UserEntity userRegister(UserEntity user);

    List<UserEntity> userList();

    UserEntity getUserId(Long id);

    UserEntity getUserByEmail(String email);

//    StatusEntity getUserStatus(String statusName);
//
//    StatusEntity getUerStatus(Long id);
//
//    StatusEntity updateStatus(StatusEntity status);

    UserEntity Login(String email, String password);

    UserEntity updateStatus(UserEntity status);

    UserEntity confirmDate(UserEntity user);

    UserEntity getUserByFirstName(String firstName);

    UserEntity updateUserStatus(UserEntity user);

    UserEntity userRegisterWithFacebook(UserEntity user, String firstName, String lastName, String email);

    UserEntity deleteUserCourse(UserEntity users, Long courseId);

    UserEntity addUserImage(UserEntity userEntity, UserImage image);

    UserEntity deleteImageUser(UserEntity userEntity, Long imageId);

    UserImage saveImageUser(UserEntity userEntity, UserImage userImage);

    Lists addFavor(Lists list, UserEntity userEntity);

    UserEntity deleteUserAccount(Long id);
}
