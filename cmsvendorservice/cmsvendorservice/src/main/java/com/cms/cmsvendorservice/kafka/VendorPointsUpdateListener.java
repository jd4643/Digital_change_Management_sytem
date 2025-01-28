/*
package com.cms.cmsvendorservice.kafka;

import com.cms.cmsvendorservice.model.VendorPointUpdateMessage;
import com.cms.cmsvendorservice.model.Vendor;
import com.cms.cmsvendorservice.repository.VendorRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

@Service
public class VendorPointsUpdateListener {

    @Autowired
    private VendorRepository vendorRepository;

    private final SqsClient sqsClient;
    private final String vendorQueueUrl;

    @Autowired
    public VendorPointsUpdateListener(SqsClient sqsClient, @Value("${aws.sqs.vendorQueueName}") String vendorQueueUrl) {
        this.sqsClient = sqsClient;
        this.vendorQueueUrl = vendorQueueUrl;
    }

    @Scheduled(fixedRate = 5000) // Poll every 5 seconds
    public void pollMessages() {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(vendorQueueUrl)
                .maxNumberOfMessages(10) // Batch size
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

        for (Message sqsMessage : messages) {
            try {
                // Deserialize the message
                VendorPointUpdateMessage vendorPointUpdateMessage = deserializeMessage(sqsMessage.body());

                // Process the message
                updateVendorPoints(vendorPointUpdateMessage);

                // Delete the message from the queue
                deleteMessage(sqsMessage);
            } catch (Exception e) {
                System.err.println("Error processing message: " + e.getMessage());
            }
        }
    }

    private void updateVendorPoints(VendorPointUpdateMessage message) {
        Vendor vendor = vendorRepository.findByVendorId(message.getVendorId())
                .orElseThrow(() -> new RuntimeException("Vendor not found"));

        vendor.setVendorPointsBalance(vendor.getVendorPointsBalance() + message.change());
        vendorRepository.save(vendor);

        System.out.println("Vendor points updated for vendor ID: " + message.getVendorId());
    }

    private void deleteMessage(Message message) {
        DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                .queueUrl(vendorQueueUrl)
                .receiptHandle(message.receiptHandle())
                .build();
        sqsClient.deleteMessage(deleteMessageRequest);
    }

    private VendorPointUpdateMessage deserializeMessage(String messageBody) {
        // Implement JSON deserialization (e.g., using Jackson or Gson)
        // Example using Jackson:
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(messageBody, VendorPointUpdateMessage.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize message", e);
        }
    }
}
*/
