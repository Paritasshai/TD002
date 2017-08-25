package tamdai.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tamdai.security.model.entity.UserEntity;

@Service
public class NotificationServiceImpl implements NotificationService {

    private JavaMailSender javaMailSender;

    @Autowired
    public NotificationServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendNotification(UserEntity user) throws MailException {
        // send mail
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setSubject("D.I.Y - Activate Your Account");
        mail.setText("Please click link for activating your account. Thank you." + "http://localhost:8080/activate/account");
        javaMailSender.send(mail);
    }
}
