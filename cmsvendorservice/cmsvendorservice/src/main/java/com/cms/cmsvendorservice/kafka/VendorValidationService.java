/*
package com.cms.cmsvendorservice.kafka;

import com.cms.cmsvendorservice.model.ValidationRequest;
import com.cms.cmsvendorservice.model.ValidationResponse;
import com.cms.cmsvendorservice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class VendorValidationService {
    @Autowired
    VendorRepository vendorRepository;

    private final KafkaTemplate<String, ValidationResponse> kafkaTemplate;

    public VendorValidationService(KafkaTemplate<String, ValidationResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "vendor-validation-requests", groupId = "vendor-service-group")
    public void validateVendor(ValidationRequest request) {
        boolean isValid = validateVendorFromDatabase(request.vendorId());
        ValidationResponse response = new ValidationResponse();
        response.setVendorId(request.vendorId());
        response.setCorrelationId(request.correlationId());
        response.setValid(isValid);

        kafkaTemplate.send("vendor-validation-responses", response);
    }

    private boolean validateVendorFromDatabase(String vendorId) {
        if (vendorId == null || vendorId.isEmpty()) {
            return false;
        }

        */
/*return vendorRepository.findByAccountNumber(accountNumber).isPresent();*//*

        return  vendorRepository.findByVendorId(vendorId).isPresent();
    }
}*/
