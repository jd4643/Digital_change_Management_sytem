package com.cms.cmsuserservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@JsonSerialize
@JsonDeserialize
public class ValidationResponse implements Serializable {
    @JsonProperty(value = "accountNumber")
    private String accountNumber;
    @JsonProperty(value = "correlationId")
    private String correlationId;
    @JsonProperty(value = "isValid")
    private boolean isValid;


    @Override
    public String toString() {
        return "ValidationResponse{" +
                "accountNumber='" + accountNumber + '\'' +
                ", correlationId='" + correlationId + '\'' +
                ", isValid=" + isValid +
                '}';
    }

    public ValidationResponse() {
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
    @JsonProperty("isValid")
    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }



    public ValidationResponse(String accountNumber, String correlationId, boolean isValid) {
        this.accountNumber = accountNumber;
        this.correlationId = correlationId;
        this.isValid = isValid;
    }
}