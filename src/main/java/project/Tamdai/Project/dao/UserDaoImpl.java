package project.Tamdai.Project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import project.Tamdai.Project.entity.User;
import project.Tamdai.Project.repository.UserRepository;

import java.util.List;

/**
 * Created by film on 08/17/2017.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public User userRegister(User user) {
        return userRepository.save(user);
    }

    @Override
    public User userLogin(String firstName, String password) {
        return userRepository.findByFirstNameAndPassword(firstName,password);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User findByUsername(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}
