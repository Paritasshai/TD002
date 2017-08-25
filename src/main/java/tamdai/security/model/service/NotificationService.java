package tamdai.security.model.service;

import tamdai.security.model.entity.UserEntity;

public interface NotificationService {

    void sendNotification(UserEntity user);
}
