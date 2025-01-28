package com.cms.cmsuserservice.dao;

import jakarta.persistence.Column;
import org.springframework.stereotype.Component;

@Component
public class UserDetailDao {
    private String accountNumber;
    private String name;
    private double pointsBalance = 0;

    public UserDetailDao(double pointsBalance, String name, String accountNumber) {
        this.pointsBalance = pointsBalance;
        this.name = name;
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "UserDetailDao{" +
                "accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", pointsBalance=" + pointsBalance +
                '}';
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

    public void setPointsBalance(double pointsBalance) {
        this.pointsBalance = pointsBalance;
    }

    public UserDetailDao() {
    }
}
