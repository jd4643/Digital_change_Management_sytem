/*
package com.cms.cmstransactionservice.kafka;


import com.cms.cmstransactionservice.model.ValidationResponse;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class ValidationResponseConsumer {

    private final ConcurrentHashMap<String, ValidationResponse> userValidationCache = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, ValidationResponse> vendorValidationCache = new ConcurrentHashMap<>();

    @KafkaListener(topics = "user-validation-responses", groupId = "transaction-service-group")
    public void handleUserValidationResponse(ValidationResponse response) {
        userValidationCache.put(response.correlationId(), response);
    }

    @KafkaListener(topics = "vendor-validation-responses", groupId = "transaction-service-group")
    public void handleVendorValidationResponse(ValidationResponse response) {
        vendorValidationCache.put(response.correlationId(), response);
    }

    public ValidationResponse getValidationResponse(String correlationId, String type) {
        try {
            // Wait for the validation response (simulate blocking for simplicity)
            for (int i = 0; i < 10; i++) { // Retry for 10 seconds
                ValidationResponse response = type.equals("user")
                        ? userValidationCache.get(correlationId)
                        : vendorValidationCache.get(correlationId);

                if (response != null) {
                    return response;
                }
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        throw new RuntimeException("Validation timeout or failed for " + type);
    }
}*/
