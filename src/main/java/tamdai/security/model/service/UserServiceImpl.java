package tamdai.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tamdai.security.model.dao.UserDao;
import tamdai.security.model.entity.UserEntity;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private JavaMailSender javaMailSender;

    @Autowired
    public UserServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Autowired
    UserDao userDao;

    @Override
    public UserEntity userRegister(UserEntity user) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(user.getEmail());
        mail.setSubject("D.I.Y - Activate Your Account");
        mail.setText("Please click link for activate your account." + "http://localhost:8080/activate/account");
        javaMailSender.send(mail);
        return userDao.userRegister(user);
    }

    @Override
    public List<UserEntity> userList() {
        return userDao.userList();
    }

}
