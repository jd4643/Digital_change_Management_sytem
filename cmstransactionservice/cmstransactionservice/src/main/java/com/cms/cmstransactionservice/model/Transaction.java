package com.cms.cmstransactionservice.model;



import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transaction_id;
    @Column
    private String accountNumber;
    @Column
    private double totalAmount;
    @Column
    private double cashGiven;
    @Column
    private double changeAmount;
    @Column
    private String vendorId;


    public Transaction(String vendorId) {
        this.vendorId = vendorId;
    }

    public String vendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime timestamp;


    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Vendor vendor;*/



/*
    public User user() {
        return user;
    }

    public Vendor vendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setUser(User user) {
        this.user = user;
    }*/

    public Transaction(long transaction_id, String accountNumber, double totalAmount, double cashGiven, double changeAmount) {
        this.transaction_id = transaction_id;
        this.accountNumber = accountNumber;
        this.totalAmount = totalAmount;
        this.cashGiven = cashGiven;
        this.changeAmount = changeAmount;
        this.timestamp = timestamp;
        /*this.user = user;
        this.vendor = vendor;*/

    }


    public Transaction() {
    }

    public long id() {
        return transaction_id;
    }

    public void setId(long id) {
        this.transaction_id = id;
    }

    public String accountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transaction_id=" + transaction_id +
                ", accountNumber='" + accountNumber + '\'' +
                ", totalAmount=" + totalAmount +
                ", cashGiven=" + cashGiven +
                ", changeAmount=" + changeAmount +
                ", timestamp=" + timestamp +
               /* ", user=" + user +
                ", vendor=" + vendor +*/
                '}';
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double totalAmount() {
        return totalAmount;
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

    public double changeAmount() {
        return changeAmount;
    }

    public void setChangeAmount(double changeAmount) {
        this.changeAmount = changeAmount;
    }

    public LocalDateTime timestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
