package com.cms.cmsuserservice.controller;

import com.cms.cmsuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserValidationController {
    @Autowired
    UserService userService;
    @GetMapping("validate/{accountNumber}")
    public ResponseEntity<Boolean> validateUser(@PathVariable String accountNumber){
        boolean isValid = userService.validateAccount(accountNumber);
        return ResponseEntity.ok(isValid);

      /*  return null;*/
    }
}
