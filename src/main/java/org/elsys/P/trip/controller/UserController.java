package org.elsys.P.trip.controller;

import org.elsys.P.trip.entity.User;
import org.elsys.P.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login() {

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void register() {

    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout() {

    }
}
