/*
package com.cms.cmstransactionservice;


import com.cms.cmstransactionservice.service.SqsMessagingService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SqsMessagingServiceTest {

    @Test
    public void testSendMessage() {
        SqsClient mockSqsClient = Mockito.mock(SqsClient.class);
        String queueUrl = "https://sqs.us-east-1.amazonaws.com/224414353090/vendor-point-updates-queue";
        String message = "Test message";

        SqsMessagingService service = new SqsMessagingService(mockSqsClient, queueUrl, queueUrl);
        service.sendMessage(queueUrl, message);

        Mockito.verify(mockSqsClient).sendMessage(Mockito.any(SendMessageRequest.class));
    }
}*/
