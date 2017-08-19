package project.Tamdai.Project.controller;

import org.springframework.validation.BindingResult;
import project.Tamdai.Project.entity.User;
import project.Tamdai.Project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by film on 8/17/2017.
 */

@CrossOrigin
@RestController
@RequestMapping("/")

public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public List<User> userList() {
        return userService.userList();
    }

    @RequestMapping(value = "user/login", method = RequestMethod.GET)
    public User userLogin(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        return userService.userLogin(username,password);
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User userRegister(@RequestBody User user, BindingResult bindingResult) {
        return userService.userRegister(user);
    }


}
