/*
package com.cms.cmsvendorservice;

import com.cms.cmsvendorservice.model.ValidationRequest;
import com.cms.cmsvendorservice.model.ValidationResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testSerialiazation {
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

        assertEquals(response.vendorId(), deserialized.vendorId());
        assertEquals(response.correlationId(), deserialized.correlationId());
        assertEquals(response.isValid(), deserialized.isValid());
    }

    @Test
    void requestTestSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        ValidationRequest request = new ValidationRequest("123456",  "correlation-123");
        */
/*ValidationResponse response = new ValidationResponse("123456", "correlation-123", true);*//*


        // Serialize to JSON
        String json = mapper.writeValueAsString(request);
        System.out.println("Serialized JSON: " + json);

        // Deserialize back to object
        ValidationRequest deserialized = mapper.readValue(json, ValidationRequest.class);
        System.out.println("Deserialized Object: " + deserialized);

        assertEquals(request.vendorId(), deserialized.vendorId());
        assertEquals(request.correlationId(), deserialized.correlationId());
        */
/*assertEquals(request.accountNumber(), deserialized.accountNumber());*//*

    }
}
*/
