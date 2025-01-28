/*
package com.cms.cmsvendorservice;

import com.cms.cmsvendorservice.kafka.VendorValidationService;
import com.cms.cmsvendorservice.model.ValidationRequest;
import com.cms.cmsvendorservice.model.ValidationResponse;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
*/
/*@ActiveProfiles("test")*//*

@EmbeddedKafka(partitions = 1, topics = {"vendor-validation-requests", "vendor-validation-responses"})
public class VendorValidationServiceTest {

    @Autowired
    private KafkaTemplate<String, ValidationRequest> kafkaTemplate;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @InjectMocks
    @Autowired
    private VendorValidationService vendorValidationService;

    @Test
    void testVendorValidationConsumesAndResponds() {
        // Given: A ValidationRequest message
        String inputTopic = "vendor-validation-requests";
        String outputTopic = "vendor-validation-responses";

        ValidationRequest request = new ValidationRequest("vendor-001", "correlation-123");
        kafkaTemplate.send(inputTopic, request);

      */
/*  // Then: Verify that VendorValidationService consumes the request and produces a response
        ConsumerRecord<String, ValidationResponse> record = KafkaTestUtils.getSingleRecord(
                KafkaTestUtils.consumerProps("test-group", "true", embeddedKafkaBroker),
                outputTopic
        );*//*


        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("test-group", "true", embeddedKafkaBroker);
        consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put("value.deserializer", "org.springframework.kafka.support.serializer.JsonDeserializer");
        consumerProps.put("spring.json.trusted.packages", "*");
        Consumer<String, ValidationResponse> consumer = new KafkaConsumer<>(consumerProps);
        consumer.subscribe(Collections.singletonList(outputTopic));

        // Fetch the response from the consumer
        ConsumerRecord<String, ValidationResponse> record = KafkaTestUtils.getSingleRecord(consumer, outputTopic);


        // Verify the response
        assertThat(record).isNotNull();
        ValidationResponse response = record.value();
        assertThat(response).isNotNull();
        assertThat(response.vendorId()).isEqualTo(request.vendorId());
        assertThat(response.correlationId()).isEqualTo(request.correlationId());
        assertThat(response.isValid()).isFalse(); // Based on expected processing logic
    }
}*/
