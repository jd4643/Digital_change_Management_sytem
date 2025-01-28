/*
package com.cms.cmsvendorservice.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


public class ValidationRequest {
   */
/* @JsonProperty(value ="accountNumber")
    private String accountNumber;*//*

    @JsonProperty(value ="vendorId")
    private String vendorId;
    @JsonProperty(value ="correlationId")
    private String correlationId;



    public String vendorId() {
        return vendorId;
    }

  */
/*  @Override
    public String toString() {
        return "ValidationRequest{" +
                "accountNumber='" + accountNumber + '\'' +
                ", vendorId='" + vendorId + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }*//*


    @Override
    public String toString() {
        return "ValidationRequest{" +
                "vendorId='" + vendorId + '\'' +
                ", correlationId='" + correlationId + '\'' +
                '}';
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }


  */
/*  public String accountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }*//*


    public String correlationId() {
        return correlationId;
    }

    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }



    public ValidationRequest() {
    }

   */
/* public ValidationRequest(String accountNumber, String vendorId, String correlationId) {
        this.accountNumber = accountNumber;
        this.vendorId = vendorId;
        this.correlationId = correlationId;
    }*//*


    public ValidationRequest(String vendorId, String correlationId) {
        this.vendorId = vendorId;
        this.correlationId = correlationId;
    }
}*/
