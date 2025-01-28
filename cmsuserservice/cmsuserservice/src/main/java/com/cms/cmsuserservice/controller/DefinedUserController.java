package com.cms.cmsuserservice.controller;

import com.cms.cmsuserservice.model.User;
import com.cms.cmsuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping("/profile")
public class DefinedUserController {

    @Autowired
    private UserService userService;

    // Get user profile by account number (Path Variable)
    @PostMapping("/{accountNumber}")
    public ResponseEntity<User> userProfile(
            @RequestHeader("X-User-Role") String role,
            @PathVariable String accountNumber) throws AccessDeniedException {

        // Check if the user has the required role
        if (!"USER".equals(role)) {
            throw new AccessDeniedException("Access denied");
        }

        // Fetch the user profile using the account number
        User user = userService.getUserByAccountNumber(accountNumber);
        return ResponseEntity.ok(user);
    }

    // Handle Access Denied Exception
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<String> handleAccessDeniedException(AccessDeniedException e) {
        return ResponseEntity.status(403).body("Access Denied: " + e.getMessage());
    }
}
