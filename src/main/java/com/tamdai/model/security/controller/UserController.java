package com.tamdai.model.security.controller;

import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.security.service.NotificationService;
import com.tamdai.model.security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "user/login")
    public ResponseEntity<UserEntity> Login(@RequestParam("Email") String email, @RequestParam("Password") String password) {
        UserEntity user = userService.Login(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
//    http://localhost:8080/login?FirstName=film&Password=4432

    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public UserEntity userRegister(@RequestBody UserEntity user, BindingResult bindingResult) {
        userService.userRegister(user);
        notificationService.sendNotification(user);
        return user;
    }

//    @RequestMapping(value = "user/forgotPassword", method = RequestMethod.POST)
//    public String forgotPassword() {
//        return "Forgot?";
//    }

//    @RequestMapping(value = "userSignUp")
//    public BankStatementService userSignUp(@RequestBody BankStatementService user, BindingResult bindingResult) {
//        return userService.userRegister(user);
//    }

//    @RequestMapping(value = "getUserByToken", method = RequestMethod.GET)
//    public BankStatement getUserByToken(@RequestParam("userID") String userID) {
//        return userService.getUserByToken(userID);
//    }

    @RequestMapping(value = "activate/account/{id}", method = RequestMethod.GET)
    public String getUrlConfirm(@PathVariable("id") Long id,
                                @RequestParam("statusName") String statusName) {
        UserEntity status = userService.getUserId(id);
        UserEntity user = userService.getUserId(id);
        status.setStatus(statusName);
        userService.updateStatus(status);
        userService.confirmDate(user);

        String text = "Activate Email Success";
        String html = "<h1>" + text + "</h1>";
        String text1 = "Please login to website";
        String html1 = "\n <a href='http://localhost:4200/loginTemplate'>Back To Website</a>";
        return "\n" + html + "\n" + text1 + html1;
    }

    @RequestMapping(value = "update/userStatus/{id}", method = RequestMethod.PUT)
    public UserEntity updateUserStatus(@PathVariable("id") Long id,
                                       @RequestParam("statusName") String statusName) {

        UserEntity user = userService.getUserId(id);
        user.setStatus(statusName);
        return userService.updateUserStatus(user);
    }

//    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
//    public BankStatement getUserId(@PathVariable("id") Long id) {
//        return userService.getUserId(id);
//    }

    @RequestMapping(value = "user/list", method = RequestMethod.GET)
    public List<UserEntity> UserList() {
        return userService.userList();
    }

    @RequestMapping(value = "user/findByEmail", method = RequestMethod.GET)
    public UserEntity getUserByEmail(@RequestParam("Email") String email) {
        return userService.getUserByEmail(email);
    }

    @RequestMapping("/addUserInSystem")
    public String process() {
        userRepository.save(new UserEntity("filmpurelove@gmail.com", "ffffffff", "adminFilm", "Hattaya", "admin", "0"));
        userRepository.save(new UserEntity("hattaya.wpm@gmail.com", "ffffffff", "instructorA", "TeacherA", "instructor", "0"));
        userRepository.save(new UserEntity("blaze.yul@gmail.com", "ffffffff", "MemberActive", "Customer", "active", "0"));
        userRepository.save(new UserEntity("film_purelove@hotmail.com", "ffffffff", "instructorB", "TeacherB", "instructor", "0"));
        return "Create Customer Done!!";
    }



}

