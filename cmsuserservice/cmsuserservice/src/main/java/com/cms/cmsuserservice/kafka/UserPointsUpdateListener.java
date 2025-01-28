package com.cms.cmsuserservice.kafka;

import com.cms.cmsuserservice.model.BalanceUpdateMessage;
import com.cms.cmsuserservice.model.User;
import com.cms.cmsuserservice.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageRequest;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageRequest;

import java.util.List;

public class UserPointsUpdateListener {
    @Autowired
    private UserRepository userRepository;

    private final SqsClient sqsClient;
    private final String queueUrl;

    @Autowired
    public UserPointsUpdateListener(SqsClient sqsClient, @Value("${aws.sqs.userQueueName}") String queueUrl) {
        this.sqsClient = sqsClient;
        this.queueUrl = queueUrl;
    }

    @Scheduled(fixedRate = 5000) // Poll every 5 seconds
    public void pollMessages() {
        ReceiveMessageRequest receiveMessageRequest = ReceiveMessageRequest.builder()
                .queueUrl(queueUrl)
                .maxNumberOfMessages(10) // Batch size
                .build();

        List<Message> messages = sqsClient.receiveMessage(receiveMessageRequest).messages();

        for (Message sqsMessage : messages) {
            try {
                // Deserialize the message to BalanceUpdateMessage
                BalanceUpdateMessage balanceUpdateMessage = deserializeMessage(sqsMessage.body());

                // Process the message
                updateUserPoints(balanceUpdateMessage);

                // Delete the message from the queue
                deleteMessage(sqsMessage);
            } catch (Exception e) {
                System.err.println("Error processing message: " + e.getMessage());
            }
        }
    }

    private void updateUserPoints(BalanceUpdateMessage message) {
        User user = userRepository.findByAccountNumber(message.accountNumber())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setPointsBalance(user.pointsBalance() + message.change());
        userRepository.save(user);

        System.out.println("User points updated for account: " + message.accountNumber());
    }

    private void deleteMessage(Message message) {
        DeleteMessageRequest deleteMessageRequest = DeleteMessageRequest.builder()
                .queueUrl(queueUrl)
                .receiptHandle(message.receiptHandle())
                .build();
        sqsClient.deleteMessage(deleteMessageRequest);
    }

    private BalanceUpdateMessage deserializeMessage(String messageBody) {
        // Implement JSON deserialization (e.g., using Jackson or Gson)
        // Example with Jackson:
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(messageBody, BalanceUpdateMessage.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize message", e);
        }
    }
}
