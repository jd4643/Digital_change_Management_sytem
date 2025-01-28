package com.cms.cmsuserservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceUpdateMessage {
    @JsonProperty(value = "accountNumber")
    private String accountNumber; // or vendorId
    @JsonProperty(value = "change")
    private double change;

    public BalanceUpdateMessage() {
    }

    @Override
    public String toString() {
        return "BalanceUpdateMessage{" +
                "accountNumber='" + accountNumber + '\'' +
                ", change=" + change +
                '}';
    }

    public BalanceUpdateMessage(String accountNumber, double change) {
        this.accountNumber = accountNumber;
        this.change = change;
    }

    public String accountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double change() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
}
