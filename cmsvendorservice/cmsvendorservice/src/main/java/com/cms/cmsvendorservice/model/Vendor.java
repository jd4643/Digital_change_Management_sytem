package com.cms.cmsvendorservice.model;


import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Entity
@Table(name = "vendor")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "vendor_id", unique = true, nullable = true)
    private String vendorId;

    @Column(name = "vendor_name", nullable = true)
    private String nameOfVendor;

    @Column(name = "vendor_points_balance", nullable = false)
    private double vendorPointsBalance = 0;


    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendorMonthlyPointsBalance> vendorMonthlyPointsBalanceList = new ArrayList<>();

    public Vendor(long id, String vendorId, String nameOfVendor, double vendorPointsBalance) {
        this.id = id;
        this.vendorId = vendorId;
        this.nameOfVendor = nameOfVendor;
        this.vendorPointsBalance = vendorPointsBalance;
    }

    public Vendor() {
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", vendorId='" + vendorId + '\'' +
                ", nameOfVendor='" + nameOfVendor + '\'' +
                ", vendorPointsBalance=" + vendorPointsBalance +
                ", vendorMonthlyPointsBalanceList=" + vendorMonthlyPointsBalanceList +
                '}';
    }

    public Vendor(List<VendorMonthlyPointsBalance> vendorMonthlyPointsBalanceList) {
        this.vendorMonthlyPointsBalanceList = vendorMonthlyPointsBalanceList;
    }

    public List<VendorMonthlyPointsBalance> vendorMonthlyPointsBalanceList() {
        return vendorMonthlyPointsBalanceList;
    }

    public void setVendorMonthlyPointsBalanceList(List<VendorMonthlyPointsBalance> vendorMonthlyPointsBalanceList) {
        this.vendorMonthlyPointsBalanceList = vendorMonthlyPointsBalanceList;
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getNameOfVendor() {
        return nameOfVendor;
    }

    public void setNameOfVendor(String nameOfVendor) {
        this.nameOfVendor = nameOfVendor;
    }

    public double getVendorPointsBalance() {
        return vendorPointsBalance;
    }

    public void setVendorPointsBalance(double vendorPointsBalance) {
        this.vendorPointsBalance = vendorPointsBalance;
    }
}