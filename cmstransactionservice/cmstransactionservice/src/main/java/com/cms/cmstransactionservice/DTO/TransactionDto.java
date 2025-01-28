package com.cms.cmstransactionservice.DTO;

public class TransactionDto {

    private String accountNumber;
    private String vendorId;
    private double totalAmount;
    private double cashGiven;

    public String accountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double totalAmount() {
        return totalAmount;
    }

    public String vendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public TransactionDto(String vendorId) {
        this.vendorId = vendorId;
    }

    public TransactionDto() {
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public double cashGiven() {
        return cashGiven;
    }

    public void setCashGiven(double cashGiven) {
        this.cashGiven = cashGiven;
    }
}