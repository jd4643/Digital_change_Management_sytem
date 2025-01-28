package com.dcms.dcmsSecurity.model;

import org.hibernate.annotations.processing.Pattern;
import org.springframework.stereotype.Component;

@Component
public class RegistrationRequest {


    private String username;
    private String password;
    private String email;

    public RegistrationRequest() {
    }

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
