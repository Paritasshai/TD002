package com.tamdai.model.security.dao;

import com.tamdai.model.security.entity.Lists;
import com.tamdai.model.security.entity.UserEntity;
import com.tamdai.model.security.entity.UserImage;

import java.util.List;

public interface UserDao {

    UserEntity userRegister(UserEntity user);

    List<UserEntity> userList();

    UserEntity getUserId(Long id);

    UserEntity getUserByEmail(String email);

    UserEntity updateStatus(UserEntity status);

    UserEntity getUserByFirstName(String firstName);

    UserEntity updateUserStatus(UserEntity user);

    UserEntity userRegisterWithFacebook(UserEntity user, String firstName, String lastName, String email);

    UserEntity updateUser(UserEntity users);

    UserImage saveImageUser(UserImage userImage);

    Lists saveList(Lists list, UserEntity userEntity);

    UserEntity deleteUserAccount(UserEntity userEntity);
}
