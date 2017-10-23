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
        mail.setSubject("MakeHappen - Activate Your Account");
        mail.setText("http://localhost:8080/activate/account" + "/" + user.getId() + "?statusName=active");
        javaMailSender.send(mail);

    }

    public void sendNotificationForgot(UserEntity user) throws MailException {

        //sendEmail
        SimpleMailMessage mailForgotPass = new SimpleMailMessage();
        mailForgotPass.setTo(user.getEmail());
        mailForgotPass.setSubject("MakeHappen - Create New Password");
        mailForgotPass.setText("Your password is: " + user.getPassword());
        javaMailSender.send(mailForgotPass);

    }
}
