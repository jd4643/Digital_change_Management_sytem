package com.dcms.dcmsSecurity.service;

import com.dcms.dcmsSecurity.model.LoginUser;
import com.dcms.dcmsSecurity.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {
    @Autowired
    private UserRepository userRepository;

    public LoginUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void saveUser(LoginUser loginuser) {
        userRepository.save(loginuser);
    }
}
