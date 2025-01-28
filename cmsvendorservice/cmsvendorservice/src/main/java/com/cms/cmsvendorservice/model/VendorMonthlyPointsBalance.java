package com.cms.cmsvendorservice.model;


import jakarta.persistence.*;

@Entity
@Table(name = "vendor_monthly_points_balance")
public class VendorMonthlyPointsBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String month; // e.g., "2024-11"

    public double points() {
        return points;
    }

    @Override
    public String toString() {
        return "VendorMonthlyPointsBalance{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", points=" + points +
                '}';
    }

    public VendorMonthlyPointsBalance(double points, String month, Vendor vendor) {
        this.points = points;
        this.month = month;
        this.vendor = vendor;
    }

    public VendorMonthlyPointsBalance(long id, String month, double points, Vendor vendor) {
        this.id = id;
        this.month = month;
        this.points = points;
        this.vendor = vendor;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public long id() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String month() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Vendor vendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Column(nullable = false)
    private double points;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id", referencedColumnName = "vendor_id")
    private Vendor vendor;

    public VendorMonthlyPointsBalance() {
    }
}
