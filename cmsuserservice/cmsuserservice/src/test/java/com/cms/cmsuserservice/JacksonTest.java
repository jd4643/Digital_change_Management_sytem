package com.cms.cmsuserservice;

import com.cms.cmsuserservice.model.ValidationRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JacksonTest {

    @Test
    void testSerializationAndDeserialization() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Create an instance of ValidationRequest
        ValidationRequest request = new ValidationRequest("123456", "001", "correlation-123");

        // Serialize to JSON
        String json = objectMapper.writeValueAsString(request);

        // Deserialize JSON back to object
        ValidationRequest deserializedRequest = objectMapper.readValue(json, ValidationRequest.class);

        // Assert values
        assertEquals("123456", deserializedRequest.accountNumber());
        assertEquals("001", deserializedRequest.vendorId());
        assertEquals("correlation-123", deserializedRequest.correlationId());
    }
}