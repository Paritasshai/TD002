package com.tamdai.model.security.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.tamdai.model.security.entity.UserEntity;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

@Service
public class NotificationServiceImpl implements NotificationService {

    private JavaMailSender javaMailSender;

//    @Autowired
//    public NotificationServiceImpl(JavaMailSender javaMailSender) {
//        this.javaMailSender = javaMailSender;
//    }

    public static JsonNode sendSimpleMessage() throws UnirestException {

        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "sandbox2af43c905abc4c5995f7043d055e94fa.mailgun.org" + "/messages")
                .basicAuth("api", "key-56e09febba428de6db919a5820e62aa2")
                .queryString("from", "postmaster@sandbox2af43c905abc4c5995f7043d055e94fa.mailgun.org")
                .queryString("to", "filmpurelove@gmail.com")
                .queryString("subject", "hello")
                .queryString("text", "testing")
                .asJson();

        return request.getBody();
    }

//    public void sendNotification(UserEntity user) throws Exception {
//
////        try {
////            Properties props = System.getProperties();
////            props.put("mail.smtps.host", "smtp.mailgun.org");
////            props.put("mail.smtps.auth", "true");
////
////            System.out.println("aaaaaaaaaaaaaaaa");
////
////            Session session = Session.getInstance(props, null);
////            Message msg = new MimeMessage(session);
////            msg.setFrom(new InternetAddress("sandbox2af43c905abc4c5995f7043d055e94fa.mailgun.org"));
////
////            System.out.println("bbbbbbbbbbbbbbbbb");
////
////            InternetAddress[] addrs = InternetAddress.parse("filmpurelove@gmail.com", false);
////            msg.setRecipients(Message.RecipientType.TO, addrs);
////
////            System.out.println("ccccccccccccccccc");
////
////            msg.setSubject("Hello");
////            msg.setText("Testing some Mailgun awesomness");
////            msg.setSentDate(new Date());
////
////            System.out.println("ddddddddddddddddd");
////
////            SMTPTransport t =
////                    (SMTPTransport) session.getTransport("smtps");
////            t.connect("smtp.mailgun.com",465, "postmaster@sandbox2af43c905abc4c5995f7043d055e94fa.mailgun.org", "79bb938524fe514dc21699c42f05959c");
////            t.sendMessage(msg, msg.getAllRecipients());
////
////            System.out.println("ddddddddddddddddd");
////            System.out.println("Response: " + t.getLastServerResponse());
////
////            t.close();
////        } catch (Exception ex) {
////            System.out.println("Mail fail");
////            System.out.println(ex);
////        }
//
////        //sendEmail
////        SimpleMailMessage mail = new SimpleMailMessage();
////        mail.setTo(user.getEmail());
////        mail.setSubject("Tamdai - Activate Your Account");
//////        String message1 = ("http://103.76.180.120:8080/tamdai-service/activate/account" + "/" + user.getId() + "?statusName=active");
////        String message1 = ("http://localhost:8080/activate/account" + "/" + user.getId() + "?statusName=active");
////        mail.setText(message1);
////        javaMailSender.send(mail);
//
//}

    public void sendNotificationForgot(UserEntity user) throws MailException {

        //sendEmail
        SimpleMailMessage mailForgotPass = new SimpleMailMessage();
        mailForgotPass.setTo(user.getEmail());
        mailForgotPass.setSubject("MakeHappen - Create New Password");
        mailForgotPass.setText("Your password is: " + user.getPassword());
        javaMailSender.send(mailForgotPass);

    }
}
