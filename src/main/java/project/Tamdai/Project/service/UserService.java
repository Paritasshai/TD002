package project.Tamdai.Project.service;

import project.Tamdai.Project.entity.User;

import java.util.List;

/**
 * Created by film on 08/17/2017.
 */

public interface UserService {

    List<User> userList();

    User userRegister(User user);

    User findByUserName(String firstName);

    User userLogin(String firstName, String password);

    User getUserById(Long id);
}
