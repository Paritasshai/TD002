package com.tamdai.model.security.service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;
import com.tamdai.model.security.entity.UserEntity;

@Service
public class NotificationServiceImpl {

    public static JsonNode activateMessage(UserEntity user) throws UnirestException {

        System.out.println("=================================================================");
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "course.tamdai.net" + "/messages")
                .basicAuth("api", "key-56e09febba428de6db919a5820e62aa2")
                .queryString("from", "Tamdai.net@course.tamdai.net")
                .queryString("to", user.getEmail())
                .queryString("subject", "Activate Your Account")
                .field("html", "<html><body>")
                .field("html", "<img src=\"https://firebasestorage.googleapis.com/v0/b/tamdai-b7326.appspot.com/o/tamdaiLogo.png?alt=media&token=b1a4a7f1-4eb0-4870-9569-43a67a68eb2e\"><br><p>สวัสดีครับ<br>\n" + "\n" + "<br>พวกเราชาว http://course.tamdai.net ชุมชนออนไลน์ของนักประดิษฐ์และนักสร้างสรรค์<br> สถานที่แลกเปลี่ยนความรู้ ทักษะ และประสบการณ์ร่วมกัน แห่งแรกของเมืองไทย\n<br>" +
                        "\n" +
                        "\n<br><br>" +
                        "<br>ตอนนี้คุณได้ลงทะเบียนเข้าใช้ระบบ ด้วยอีเมล์เรียบร้อยแล้ว<br>\n" +
                        "\n" +
                        "\n" +
                        "กรุณายืนยันผ่านอีเมล์ของคุณ โดยการคลิ๊ก <a href=\"http://103.76.180.120:8080/tamdai-service/activate/account" + "/" + user.getId() + "?statusName=active\"> <button> Activate Email </button></a> \n\n เพื่อเข้าสู่ระบบ\n<br>" +
                        "\n" +
                        "\n<br>" +
                        "<br>ยินดีต้อนรับ \n" +
                        "และขอบคุณในการร่วมกันส่งเสริม ‘สังคมแห่งการสร้างสรรค์’\n" +
                        "\n<br>" +
                        "<br><br>ทีมงาน TamDai.net</p>")
                .field("html", "</html></body>")
                .asJson();

        System.out.println("=================================================================");
        System.out.println(user.getEmail());
        String content = request.getBody().toString();
        System.out.println(content);
        System.out.println("=================================================================");

        return request.getBody();
    }
    public static JsonNode forgotPasswordMessage(UserEntity user) throws UnirestException {

        System.out.println("=================================================================");
        HttpResponse<JsonNode> request = Unirest.post("https://api.mailgun.net/v3/" + "course.tamdai.net" + "/messages")
                .basicAuth("api", "key-56e09febba428de6db919a5820e62aa2")
                .queryString("from", "Tamdai.net@course.tamdai.net")
                .queryString("to", user.getEmail())
                .queryString("subject", "Forgot Password")
                .queryString("text", "Your Password: " + user.getPassword())
                .asJson();

        System.out.println("=================================================================");
        System.out.println(user.getEmail());
        String content = request.getBody().toString();
        System.out.println(content);
        System.out.println("=================================================================");

        return request.getBody();
    }
}
