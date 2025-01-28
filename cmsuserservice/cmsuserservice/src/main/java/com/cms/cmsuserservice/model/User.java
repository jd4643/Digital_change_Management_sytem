package com.cms.cmsuserservice.model;


import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column
    private String name;

    @Column(name = "email")
    private String email;

    @Column
    private double pointsBalance = 0;

    public long id() {
        return id;
    }

    public User(String email) {
        this.email = email;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setName(String name) {
        this.name = name;
    }

    public double pointsBalance() {
        return pointsBalance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pointsBalance=" + pointsBalance +
                '}';
    }

    public void setPointsBalance(double pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public User() {
    }


}