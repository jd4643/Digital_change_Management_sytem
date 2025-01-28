/*
package com.cms.cmstransactionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ValidationRequest implements Serializable {

    @JsonProperty(value = "accountNumber")
    private String accountNumber;
    @JsonProperty(value = "vendorId")
    private String vendorId;

    public ValidationRequest(String vendorId) {
        this.vendorId = vendorId;
    }

    public String vendorId() {
        return vendorId;
    }

    @Override
    public String toString() {
        return "ValidationRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public ValidationRequest(String accountNumber, String correlationId) {
        this.accountNumber = accountNumber;
        this.correlationId = correlationId;
    }

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
    @JsonProperty(value ="correlationId")
    private String correlationId;

    public ValidationRequest() {
    }
}
*/
