package tamdai.security.model.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tamdai.security.model.entity.UserEntity;
import tamdai.security.model.repository.UserRepository;

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

}
