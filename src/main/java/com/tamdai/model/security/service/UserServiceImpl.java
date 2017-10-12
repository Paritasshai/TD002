package com.tamdai.model.security.service;

import com.tamdai.model.security.dao.UserDao;
import com.tamdai.model.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tamdai.model.security.entity.UserEntity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

        //setStatus
        String role = new String("new");
        user.setStatus(role);

        //setBalance
        String balance = new String("0");
        user.setBalance(balance);

        //setCreateSignUpDate
        String signUpDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        user.setSignUpDate(signUpDate);

        //setCreateDate
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
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
        String confirmDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
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
                String loginDate = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
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

}
