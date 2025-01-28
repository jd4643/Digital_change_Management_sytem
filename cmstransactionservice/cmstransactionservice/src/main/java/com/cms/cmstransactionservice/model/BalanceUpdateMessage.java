package com.cms.cmstransactionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class BalanceUpdateMessage implements Serializable {
    @JsonProperty(value = "accountNumber")
    private String accountNumber;
    @JsonProperty(value = "vendorId")
    private String vendorId;
    @JsonProperty(value = "change")
    private double change;

    public BalanceUpdateMessage() {
    }

    @Override
    public String toString() {
        return "BalanceUpdateMessage{" +
                "accountNumber='" + accountNumber + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", change=" + change +
                '}';
    }

    public String accountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

  public String vendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }


    public double change() {
        return change;
    }

    public BalanceUpdateMessage(String accountNumber, String vendorId, double change) {
        this.accountNumber = accountNumber;
        this.vendorId = vendorId;
        this.change = change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public BalanceUpdateMessage(String accountNumber, double change) {
        this.accountNumber = accountNumber;
        this.change = change;
    }
}
