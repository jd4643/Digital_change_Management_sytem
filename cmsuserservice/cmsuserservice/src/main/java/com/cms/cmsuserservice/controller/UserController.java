package com.cms.cmsuserservice.controller;

import com.cms.cmsuserservice.DTO.UserRegistrationDto;
import com.cms.cmsuserservice.model.User;
import com.cms.cmsuserservice.service.UserAlreadyExistsException;
import com.cms.cmsuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping(value = "/register", consumes = "application/json")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping(value = "/users",consumes = "application/json")
    public ResponseEntity<User> registerUser(@RequestBody UserRegistrationDto userRegistrationDto){
        System.out.println("Received payload: " + userRegistrationDto);
        User registeredUser = userService.registerUser(userRegistrationDto);

        return ResponseEntity.ok(registeredUser);


    }
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<String> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
    }






}