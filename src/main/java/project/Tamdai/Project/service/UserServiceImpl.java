package project.Tamdai.Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.Tamdai.Project.dao.UserDao;
import project.Tamdai.Project.entity.User;

import java.util.List;

/**
 * Created by film on 08/17/2017.
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> userList() {
        return userDao.userList();
    }

    @Override
    public User userRegister(User user) {
        return userDao.userRegister(user);
    }

    @Override
    public User userLogin(String username,String password) {
        return userDao.userLogin(username,password);
    }
}
