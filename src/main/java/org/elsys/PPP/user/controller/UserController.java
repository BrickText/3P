package org.elsys.PPP.user.controller;

import org.elsys.PPP.user.entity.User;
import org.elsys.PPP.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registerUserAccount(
            @RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName) {
        System.out.println(password);
        userService.registerUser(username, firstName, lastName, password, email);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal principal) {
        return principal;
    }
}
