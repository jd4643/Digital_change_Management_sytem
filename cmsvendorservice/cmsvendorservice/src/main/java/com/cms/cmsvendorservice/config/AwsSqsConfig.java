/*
package com.cms.cmsvendorservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsClient;

@Configuration
public class AwsSqsConfig {

    @Value("${aws.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.secretKey}")
    private String secretKey;

    @Value("${aws.region}")
    private String region;

    @Value("${aws.sqs.vendorQueueName}")
    private String vendorQueueName;


    @Bean
    public SqsClient sqsClient() {
        return SqsClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretKey)
                ))
                .build();
    }
    @Bean
    public String vendorQueueUrl() {
        return vendorQueueName;
    }
}*/
