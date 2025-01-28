/*
package com.cms.cmstransactionservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsMessagingService {

    private final SnsClient snsClient;
    private final String vendorTopicArn;
    private final String userTopicArn;

    @Autowired
    public SnsMessagingService(SnsClient snsClient,
                               @Value("${aws.sns.vendorPointUpdatesTopicArn}") String vendorTopicArn,
                               @Value("${aws.sns.userPointUpdatesTopicArn}") String userTopicArn) {
        this.snsClient = snsClient;
        this.vendorTopicArn = vendorTopicArn;
        this.userTopicArn = userTopicArn;
    }

    */
/**
     * Publish a message to the given SNS topic.
     *
     * @param topicArn The ARN of the SNS topic.
     * @param message  The message to publish.
     *//*

    public void publishMessage(String topicArn, String message) {
        PublishRequest publishRequest = PublishRequest.builder()
                .topicArn(topicArn)
                .message(message)
                .build();

        PublishResponse publishResponse = snsClient.publish(publishRequest);

        System.out.printf("Message published to topic %s. Message ID: %s%n", topicArn, publishResponse.messageId());
    }

    */
/**
     * Publish a user points update message.
     *
     * @param message The message body.
     *//*

    public void publishUserPointUpdate(String message) {
        publishMessage(userTopicArn, message);
    }

    */
/**
     * Publish a vendor points update message.
     *
     * @param message The message body.
     *//*

    public void publishVendorPointUpdate(String message) {
        publishMessage(vendorTopicArn, message);
    }
}*/
