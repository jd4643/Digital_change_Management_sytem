package com.cms.cmsuserservice;

import com.cms.cmsuserservice.model.ValidationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSerialization {


    @Test
    void testSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ValidationResponse response = new ValidationResponse("123456", "correlation-123", true);

        // Serialize to JSON
        String json = mapper.writeValueAsString(response);
        System.out.println("Serialized JSON: " + json);

        // Deserialize back to object
        ValidationResponse deserialized = mapper.readValue(json, ValidationResponse.class);
        System.out.println("Deserialized Object: " + deserialized);

        assertEquals(response.accountNumber(), deserialized.accountNumber());
        assertEquals(response.correlationId(), deserialized.correlationId());
        assertEquals(response.isValid(), deserialized.isValid());
    }

}
