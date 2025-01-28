package com.cms.cmsuserservice.DTO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserRegistrationDto implements Serializable {

    private String accountNumber;

    private String name;

    private String email;

    public UserRegistrationDto(String email) {
        this.email = email;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserRegistrationDto(String accountNumber, String name, String email) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
    }

    public String accountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String name() {
        return name;
    }

    public UserRegistrationDto() {
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}