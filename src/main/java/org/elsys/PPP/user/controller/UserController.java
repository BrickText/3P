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

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationForm(final HttpServletRequest request, final Model model) {
        final User accountDto = new User();
        model.addAttribute("user", accountDto);
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public void registerUserAccount(@RequestParam("username") String username, @RequestParam("password") String password,
            @RequestParam("email") String email) {
        User registered = new User(username, password, email);
        System.out.println("Sad?");
        System.out.println(registered.getUsername());
        System.out.println(registered.getEmail());
        System.out.println(registered.getPassword());
        createUserAccount(registered);
    }

    private User createUserAccount(User accountDto) {
        userService.addOrUpdateUser(accountDto);
        return accountDto;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Principal user(Principal principal) {
        return principal;
    }
}
