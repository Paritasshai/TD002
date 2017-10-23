package com.tamdai.model.security.dao;

import com.tamdai.model.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.tamdai.model.security.entity.UserEntity;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity userRegister(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserEntity> userList() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserId(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserEntity updateStatus(UserEntity status) {
        return userRepository.save(status);
    }

    @Override
    public UserEntity getUserByFirstName(String firstName) {
        return userRepository.findUserByFirstName(firstName);
    }

    @Override
    public UserEntity updateUserStatus(UserEntity user) {
        return userRepository.save(user);
    }

    @Override
    public UserEntity userRegisterWithFacebook(UserEntity user, String firstName, String lastName, String email) {
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLastName(email);
        userRepository.save(user);
        return user;
    }

    @Override
    public UserEntity updateUser(UserEntity users) {
        return userRepository.save(users);
    }

}

