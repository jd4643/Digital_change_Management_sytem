/*
package com.cms.cmstransactionservice;

import com.cms.cmstransactionservice.service.SqsMessagingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SqsIntegrationTest {

    @Autowired
    private SqsMessagingService sqsMessagingService;

    @Value("${aws.sqs.vendorPointUpdatesQueueUrl}")
    private String vendorQueueUrl;

    @Test
    public void testSendMessage() {
        sqsMessagingService.sendMessage(vendorQueueUrl, "Integration test message");
    }
}
*/
