package com.tamdai.model.security.service;

import com.tamdai.model.security.entity.UserEntity;

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

}
