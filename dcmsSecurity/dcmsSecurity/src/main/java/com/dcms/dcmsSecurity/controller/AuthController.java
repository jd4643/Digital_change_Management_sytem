package com.dcms.dcmsSecurity.controller;


import com.dcms.dcmsSecurity.jwt.JwtUtil;
import com.dcms.dcmsSecurity.model.AuthRequest;
import com.dcms.dcmsSecurity.model.LoginUser;
import com.dcms.dcmsSecurity.model.RegistrationRequest;
import com.dcms.dcmsSecurity.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest authRequest) {
        LoginUser user = loginUserService.findByUsername(authRequest.username());
        if (user != null && new BCryptPasswordEncoder().matches(authRequest.password(), user.password())) {
            return jwtUtil.generateToken(user.username(), user.role());
        }
        throw new RuntimeException("Invalid username or password");
    }



    @PostMapping("/register")
    public String register(@RequestBody RegistrationRequest registrationRequest) {
        // Check if the username already exists
        if (loginUserService.findByUsername(registrationRequest.username()) != null) {
            throw new RuntimeException("Username already exists");
        }

        // Create and save the user
        LoginUser newUser = new LoginUser();
        newUser.setUsername(registrationRequest.username());
        newUser.setPassword(passwordEncoder.encode(registrationRequest.password())); // Hash password
        newUser.setRole("USER"); // Default role
        loginUserService.saveUser(newUser);

        return "User registered successfully!";
    }
}
