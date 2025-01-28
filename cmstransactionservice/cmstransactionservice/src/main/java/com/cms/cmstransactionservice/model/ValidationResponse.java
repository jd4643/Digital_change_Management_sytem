/*
package com.cms.cmstransactionservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class ValidationResponse {
    @JsonProperty(value = "accountNumber")
    private String accountNumber;
    @JsonProperty(value = "correlationId")
    private String correlationId;

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

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    private boolean isValid;

    public ValidationResponse(String accountNumber, String correlationId, boolean isValid) {
        this.accountNumber = accountNumber;
        this.correlationId = correlationId;
        this.isValid = isValid;
    }
}
*/
