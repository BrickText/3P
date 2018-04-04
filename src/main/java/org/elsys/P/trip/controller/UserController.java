package org.elsys.P.trip.controller;

import org.elsys.P.trip.entity.User;
import org.elsys.P.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
