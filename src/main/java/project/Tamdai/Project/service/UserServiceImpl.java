package project.Tamdai.Project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import project.Tamdai.Project.dao.UserDao;
import project.Tamdai.Project.entity.Role;
import project.Tamdai.Project.entity.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Role customerRole = new Role("member");
        Set<Role> roles = new HashSet<>();
        roles.add(customerRole);
        user.setRoles(roles);
        return userDao.userRegister(user);
    }

    @Override
    @Transactional
    public User findByUserName(String firstName) {
        return userDao.findByUsername(firstName);
    }

    @Override
    public User userLogin(String firstName, String password) {
        return userDao.userLogin(firstName, password);
    }

    @Override
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }
}
