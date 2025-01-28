package com.cms.cmsuserservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;


public class ValidationRequest implements Serializable {
    @JsonProperty(value = "accountNumber")
    private String accountNumber;
    /*@JsonProperty(value = "vendorId")
    private String vendorId;*/
    @JsonProperty(value = "correlationId")
    private String correlationId;

   /* public ValidationRequest(String vendorId) {
        this.vendorId = vendorId;
    }*/
    //parameterized constructor
    public ValidationRequest(String accountNumber, String correlationId) {
        this.accountNumber = accountNumber;
        this.correlationId = correlationId;
    }

    public ValidationRequest() {
    }

   /* public String vendorId() {
        return vendorId;
    }*/

    @Override
    public String toString() {
        return "ValidationRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }

    /*public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }*/



    public String accountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String correlationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }



}

