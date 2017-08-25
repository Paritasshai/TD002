package tamdai.security.model.service;

import tamdai.security.model.entity.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity userRegister(UserEntity user);

    List<UserEntity> userList();

}
