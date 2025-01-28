/*
package com.cms.cmsuserservice.kafka;

import com.cms.cmsuserservice.model.User;
import com.cms.cmsuserservice.model.ValidationRequest;
import com.cms.cmsuserservice.model.ValidationResponse;
import com.cms.cmsuserservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserValidationService {

    @Autowired
    UserRepository userRepository;

    private final KafkaTemplate<String, ValidationResponse> kafkaTemplate;

    public UserValidationService(KafkaTemplate<String, ValidationResponse> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "user-validation-requests", groupId = "user-service-group")
    public void validateUserAccount(ValidationRequest request) {
        try {
            System.out.println("message consume:" + request);
            boolean isValid = validateAccountFromDatabase(request.accountNumber());
            System.out.println("message verified:" + request);
            ValidationResponse response = new ValidationResponse();
            response.setAccountNumber(request.accountNumber());
            response.setCorrelationId(request.correlationId());
            response.setValid(isValid);
            System.out.println("message send to user-validation-responses:"+response);
            ObjectMapper mapper = new ObjectMapper();
            System.out.println("Serialized JSON: " + mapper.writeValueAsString(response));

            kafkaTemplate.send("user-validation-responses", response);
            System.out.println("message received :"+response);
        }catch (Exception e){
            System.err.println("Error processing validation request: " + e.getMessage());
            e.printStackTrace();

        }

    }

    private boolean validateAccountFromDatabase(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return false;
        }

        return userRepository.findByAccountNumber(accountNumber).isPresent();



    }
}
*/
