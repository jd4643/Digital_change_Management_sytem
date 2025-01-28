package com.cms.cmsuserservice.service;

import com.cms.cmsuserservice.DTO.UserRegistrationDto;
import com.cms.cmsuserservice.dao.UserDetailDao;
import com.cms.cmsuserservice.model.User;
import com.cms.cmsuserservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(UserRegistrationDto userRegistrationDto){
        if (userRepository.existsByAccountNumber(userRegistrationDto.accountNumber())) {
            throw new UserAlreadyExistsException("User with AccountNumber" + userRegistrationDto.accountNumber() + " is already registered");
        }

        User user = new User();
        user.setAccountNumber(userRegistrationDto.accountNumber());
        user.setName(userRegistrationDto.name());
        user.setEmail(userRegistrationDto.email());


        return userRepository.save(user);
    }

    public boolean validateAccount(String accountNumber) {
        return userRepository.findByAccountNumber(accountNumber).isPresent();
    }

    public User getUserByAccountNumber(String accountNumber){
        return userRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + accountNumber));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


}