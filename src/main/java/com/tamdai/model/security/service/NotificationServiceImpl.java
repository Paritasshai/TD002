package com.tamdai.model.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.tamdai.model.security.entity.UserEntity;

@Service
public class NotificationServiceImpl implements NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(UserEntity user) throws MailException {

        //sendEmail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setSubject("D.I.Y - Activate Your Account");
        mail.setText("http://localhost:8080/activate/account" + "/" + user.getId() + "?statusName=active");
        javaMailSender.send(mail);

    }
}
