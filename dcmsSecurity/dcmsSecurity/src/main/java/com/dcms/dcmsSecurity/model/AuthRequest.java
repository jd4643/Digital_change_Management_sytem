package com.dcms.dcmsSecurity.model;

public class AuthRequest {
    private String username;
    private String password;

    public String username() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String password() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AuthRequest() {
    }
}
