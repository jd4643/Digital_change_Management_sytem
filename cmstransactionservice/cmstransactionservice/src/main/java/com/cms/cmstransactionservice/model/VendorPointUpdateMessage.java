package com.cms.cmstransactionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class VendorPointUpdateMessage {
    @JsonProperty(value = "vendorId")
    private String vendorId; // Account number or vendor ID
    @JsonProperty(value = "points")
    private double points;

    public VendorPointUpdateMessage() {
    }

    public VendorPointUpdateMessage(String vendorId, double points) {
        this.vendorId = vendorId;
        this.points = points;
    }

    public String vendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public double points() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "VendorPointUpdateMessage{" +
                "vendorId='" + vendorId + '\'' +
                ", points=" + points +
                '}';
    }
}
