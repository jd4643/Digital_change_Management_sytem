package com.cms.cmsuserservice;

import com.cms.cmsuserservice.kafka.UserValidationService;
import com.cms.cmsuserservice.model.User;
import com.cms.cmsuserservice.model.ValidationRequest;
import com.cms.cmsuserservice.model.ValidationResponse;
import com.cms.cmsuserservice.repository.UserRepository;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.std.StringDeserializer;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.ActiveProfiles;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
@SpringBootTest
@EmbeddedKafka(partitions = 1, topics = {"user-validation-requests", "user-validation-responses"})
class UserValidationServiceTest {

    @Autowired
    private KafkaTemplate<String, ValidationRequest> kafkaTemplate;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    @Autowired
    private UserValidationService userValidationService;

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;

    @Test
    void testValidateUserAccountConsumesAndResponds() {
        // Mock database response
        when(userRepository.findByAccountNumber(anyString())).thenReturn(Optional.of(new User()));

        // Send a ValidationRequest to the input topic
        String inputTopic = "user-validation-requests";
        String outputTopic = "user-validation-responses";

        ValidationRequest request = new ValidationRequest("123456", "001", "correlation-123");
        kafkaTemplate.send(new ProducerRecord<>(inputTopic, request));

        // Set up Kafka consumer to read from the output topic
        Map<String, Object> consumerProps = KafkaTestUtils.consumerProps("test-group", "true", embeddedKafkaBroker);
        consumerProps.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        consumerProps.put("value.deserializer", "org.springframework.kafka.support.serializer.JsonDeserializer");
        consumerProps.put("spring.json.trusted.packages", "*");
        Consumer<String, ValidationResponse> consumer = new KafkaConsumer<>(consumerProps);
        consumer.subscribe(Collections.singletonList(outputTopic));

        // Fetch the response from the consumer
        ConsumerRecord<String, ValidationResponse> record = KafkaTestUtils.getSingleRecord(consumer, outputTopic);

        // Validate the response
        assertThat(record).isNotNull();
        ValidationResponse response = record.value();
        assertThat(response).isNotNull();
        assertThat(response.accountNumber()).isEqualTo(request.accountNumber());
        assertThat(response.correlationId()).isEqualTo(request.correlationId());
        assertThat(response.isValid()).isFalse(); // Based on mocked behavior

        // Close the consumer
        consumer.close();
    }
}