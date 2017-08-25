package tamdai.security.model.controller;

import org.springframework.mail.MailException;
import tamdai.security.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tamdai.security.model.repository.UserRepository;
import tamdai.security.model.service.NotificationService;
import tamdai.security.model.service.UserService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    NotificationService notificationService;

    @RequestMapping(value = "save")
    public String process() {
        userRepository.save(new UserEntity("Mark", "Camel", "5555", "Mark@gmail.com"));
        return "Have Done!";
    }

    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public UserEntity userRegister(@RequestBody UserEntity user, BindingResult bindingResult) {
        return userService.userRegister(user);
    }

    @RequestMapping(value = "activate/account")
    public String activateAccount() {
        return "Activate Success";
    }

    @RequestMapping(value = "send/email")
    public String SignUpSuccess() {

        //create User
        UserEntity user = new UserEntity();
        user.setFirstName("film");
        user.setLastName("Hattaya");
        user.setEmail("filmpurelove@gmail.com");
        user.setPassword("4432");

        //send notification
        try {
            notificationService.sendNotification(user);
        } catch (MailException e) {
            //catch error
            return "Error in sending email: " + e.getMessage();
        }

        return "Thank you for registration with us";
    }

    @RequestMapping(value = "user/list", method = RequestMethod.GET)
    public List<UserEntity> UserList() {
        return userService.userList();
    }

}

