package com.tamdai.model.security.service;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.security.dao.UserDao;
import com.tamdai.model.security.entity.Lists;
import com.tamdai.model.security.entity.UserImage;
import com.tamdai.model.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserEntity userRegister(UserEntity user) {

        //setUserId
        String id = UUID.randomUUID().toString();
        user.setCreateUserID(id);

//        //setStatus
//        String role = new String("new");
//        user.setStatus(role);

        //setStatus
        String role = new String("new");
        user.setStatus(role);

        //setBalance
        String balance = new String("0");
        user.setBalance(balance);

        //setCreateSignUpDate
        String signUpDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setSignUpDate(signUpDate);

        //setCreateDate
        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateDate(date);

        //setCreateTime
        String timeStamp = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        user.setCreateTime(timeStamp);

        return userDao.userRegister(user);
    }

    @Override
    public List<UserEntity> userList() {
        return userDao.userList();
    }

    @Override
    public UserEntity getUserId(Long id) {
        return userDao.getUserId(id);
    }

    @Override
    public UserEntity getUserByEmail(String email) {
        return userDao.getUserByEmail(email);
    }

    @Override
    public UserEntity updateStatus(UserEntity status) {
        return userDao.updateStatus(status);
    }

    @Override
    public UserEntity confirmDate(UserEntity user) {

        //setConfirmDate
        String confirmDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setConfirmDate(confirmDate);

        userDao.userRegister(user);
        return user;
    }

    @Override
    public UserEntity getUserByFirstName(String firstName) {
        return userDao.getUserByFirstName(firstName);
    }

    @Override
    public UserEntity updateUserStatus(UserEntity user) {
        return userDao.updateUserStatus(user);
    }

    @Override
    public UserEntity userRegisterWithFacebook(UserEntity user, String firstName, String lastName, String email) {
        return userDao.userRegisterWithFacebook(user, firstName, lastName, email);
    }

    @Override
    public UserEntity Login(String email, String password) {
        UserEntity user = userDao.getUserByEmail(email);
        if (user != null) {
            String PassUserFromDB = user.getPassword();
            if (PassUserFromDB.equals(password)) {

                //setLastLoginDate
                String loginDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
                user.setLastLoginDate(loginDate);
                userDao.userRegister(user);

                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public UserEntity deleteUserCourse(UserEntity users, Long courseId) {
        Set<Course> courses = users.getCourses();
        for (Iterator<Course> it = courses.iterator(); it.hasNext(); ) {
            Course f = it.next();
            if (f.getId().equals(courseId)) {
                users.getCourses().remove(f);
            }
        }
        userDao.updateUser(users);
        return users;
    }

    @Override
    @Transactional
    public UserEntity addUserImage(UserEntity userEntity, UserImage image) {
        image = ImageUtil.resizeImage(image, 200);
        userEntity.getUserImages().add(image);
        userDao.updateStatus(userEntity);
        return userEntity;
    }

    @Override
    public UserEntity deleteImageUser(UserEntity userEntity, Long imageId) {
        Set<UserImage> images = userEntity.getUserImages();
        for (Iterator<UserImage> it = images.iterator(); it.hasNext(); ) {
            UserImage f = it.next();
            if (f.getId().equals(imageId)) {
                userEntity.getUserImages().remove(f);
            }
        }

        userDao.updateUser(userEntity);
        return userEntity;
    }

    @Override
    public UserImage saveImageUser(UserEntity userEntity, UserImage userImage) {
        userEntity.getUserImages().add(userImage);
        userDao.updateUser(userEntity);
        return userDao.saveImageUser(userImage);
    }

    @Override
    public Lists addFavor(Lists list, UserEntity userEntity) {
        return userDao.saveList(list, userEntity);
    }

    @Override
    public UserEntity deleteUserAccount(Long id) {
        UserEntity userEntity = getUserId(id);
        return userDao.deleteUserAccount(userEntity);
    }

}
