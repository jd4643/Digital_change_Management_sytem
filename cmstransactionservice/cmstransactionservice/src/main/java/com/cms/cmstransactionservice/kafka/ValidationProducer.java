/*
package com.cms.cmstransactionservice.kafka;

import com.cms.cmstransactionservice.model.BalanceUpdateMessage;
import com.cms.cmstransactionservice.model.ValidationRequest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ValidationProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    public ValidationProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendUserValidationRequest(ValidationRequest request) {
        kafkaTemplate.send("user-validation-requests", request);
    }

    public void sendVendorValidationRequest(ValidationRequest request) {
        kafkaTemplate.send("vendor-validation-requests", request);
    }

    public void sendUserBalanceUpdate(String accountNumber, double change) {
        kafkaTemplate.send("user-balance-updates", new BalanceUpdateMessage(accountNumber, change));
    }

    public void sendVendorBalanceUpdate(String vendorId, double change) {
        kafkaTemplate.send("vendor-balance-updates", new BalanceUpdateMessage(vendorId, change));

    }



}
*/
