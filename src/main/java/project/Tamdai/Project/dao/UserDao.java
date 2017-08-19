package project.Tamdai.Project.dao;

import project.Tamdai.Project.entity.User;

import java.util.List;

/**
 * Created by film on 8/17/2017.
 */

public interface UserDao {

    List<User> userList();

    User userRegister(User user);

    User userLogin(String username,String password);
}
