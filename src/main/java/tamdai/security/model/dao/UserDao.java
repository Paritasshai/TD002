package tamdai.security.model.dao;

import tamdai.security.model.entity.UserEntity;

import java.util.List;

public interface UserDao {

    UserEntity userRegister(UserEntity user);

    List<UserEntity> userList();

}
