package com.cms.cmsvendorservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VendorPointUpdateMessage {
    @JsonProperty(value = "vendorId")
    private String vendorId; // or vendorId
    @JsonProperty(value = "change")
    private double change;

    public VendorPointUpdateMessage() {
    }

    @Override
    public String toString() {
        return "VendorPointUpdateMessage{" +
                "vendorId='" + vendorId + '\'' +
                ", change=" + change +
                '}';
    }

    public VendorPointUpdateMessage(String vendorId, double change) {
        this.vendorId = vendorId;
        this.change = change;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public double change() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }
}
