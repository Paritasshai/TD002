package com.tamdai.model.security.service;

import com.tamdai.model.security.entity.UserEntity;

public interface NotificationService {

    void sendNotification(UserEntity user);
}
