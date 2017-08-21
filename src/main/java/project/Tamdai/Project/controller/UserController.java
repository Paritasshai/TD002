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

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    @RequestMapping(value = "user/list", method = RequestMethod.GET)
    public List<User> userList() {
        return userService.userList();
    }

    @RequestMapping(value = "user/findByUserName", method = RequestMethod.GET)
    public User findByUserName(@RequestParam("firstName") String firstName) {
        return userService.findByUserName(firstName);
    }

    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public User userLogin(@RequestParam("firstName") String firstName,
                          @RequestParam("password") String password) {
        return userService.userLogin(firstName, password);
    }

    @RequestMapping(value = "user/register", method = RequestMethod.POST)
    public User userRegister(@RequestBody User user, BindingResult bindingResult) {
        return userService.userRegister(user);
    }


}
