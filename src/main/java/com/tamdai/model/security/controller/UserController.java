package com.tamdai.model.security.controller;

import com.tamdai.model.course.entity.Course;
import com.tamdai.model.course.entity.CourseItem;
import com.tamdai.model.course.repository.CourseItemRepository;
import com.tamdai.model.course.repository.CourseRepository;
import com.tamdai.model.course.service.CourseService;
import com.tamdai.model.security.repository.UserRepository;
import com.tamdai.model.security.service.NotificationService;
import com.tamdai.model.security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.tamdai.model.security.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Autowired
    CourseService courseService;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseItemRepository courseItemRepository;

    @RequestMapping(value = "user/login")
    public ResponseEntity<UserEntity> Login(@RequestParam("Email") String email, @RequestParam("Password") String password) {
        UserEntity user = userService.Login(email, password);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @RequestMapping(value = "user/facebook")
    public String helloFacebook() {
        return "ddddddddddddddd";
    }

    //    http://localhost:8080/login?FirstName=film&Password=4432
    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public UserEntity userRegister(@RequestBody UserEntity user, BindingResult bindingResult) {
        userService.userRegister(user);
        notificationService.sendNotification(user);
        return user;
    }

    @RequestMapping(value = "user/registerWithFacebook", method = RequestMethod.POST)
    public UserEntity userRegisterWithFacebook(@RequestBody UserEntity user,
                                               @PathVariable("firstName") String firstName,
                                               @PathVariable("lastName") String lastName,
                                               @PathVariable("email") String email,
                                               BindingResult bindingResult) {
        return userService.userRegisterWithFacebook(user, firstName, lastName, email);
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

    @RequestMapping("/addDataInSystem")
    public String process() {

        userRepository.save(new UserEntity(1L, "filmpurelove@gmail.com", "ffffffff", "adminFilm", "Hattaya", "admin", "0"));
        userRepository.save(new UserEntity(2L, "hattaya.wpm@gmail.com", "ffffffff", "instructorA", "TeacherA", "instructor", "0"));
        userRepository.save(new UserEntity(3L, "blaze.yul@gmail.com", "ffffffff", "MemberActive", "Customer", "active", "500"));
        userRepository.save(new UserEntity(4L, "film_purelove@hotmail.com", "ffffffff", "instructorB", "TeacherB", "instructor", "0"));

        courseRepository.save(new Course(1L, 2L, "Course 1", "Technology for life 1.","200", "true", "null"));
        courseRepository.save(new Course(2L, 2L, "Course 2", "Technology for life 2.","100",  "true", "null"));
        courseRepository.save(new Course(3L, 2L, "Course 3", "Technology for life 3.","150",  "true", "null"));
        courseRepository.save(new Course(4L, 2L, "Course 4", "Technology for life 4.","250",  "true", "null"));
        return "Create Done!!";
    }

//    @RequestMapping(value = "savePurchaseCart/{id}/no", method = RequestMethod.PUT)
//    public UserEntity userSavePurchaseCart(@PathVariable("id") Long id,
//                                           @RequestParam("userId") Long userId) {
//        UserEntity user = userService.getUserId(userId);
//        return userService.userSavePurchaseCart(user, id);
//    }

}

