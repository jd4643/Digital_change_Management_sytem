/*
package com.cms.cmstransactionservice;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;
import software.amazon.awssdk.services.sqs.model.SendMessageRequest;

public class SqsTest {
    public static void main(String[] args) {
        String accessKeyId = "AKIATIQBDI3BPVFL3KUF";
        String secretKey = "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";
        String region = "us-east-1";
        String queueUrl = "https://sqs.us-east-1.amazonaws.com/224414353090/vendor-point-updates-queue";

        SqsClient sqsClient = SqsClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretKey)
                ))
                .build();

        try {
            SendMessageRequest request = SendMessageRequest.builder()
                    .queueUrl(queueUrl)
                    .messageBody("Text message from application")
                    .build();

            sqsClient.sendMessage(request);
            System.out.println("Message sent successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/
