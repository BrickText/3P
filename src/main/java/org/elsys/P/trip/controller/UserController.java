package org.elsys.P.trip.controller;

import org.elsys.P.trip.entity.User;
import org.elsys.P.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void registerUser(@RequestParam("username") String username, @RequestParam("email") String email,
                             @RequestParam("password") String password) {
        User user = new User(username, password, email);
        userService.addOrUpdateUser(user);
    }
}
