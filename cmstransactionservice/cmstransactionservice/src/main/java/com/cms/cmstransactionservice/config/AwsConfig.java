/*
package com.cms.cmstransactionservice.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class AwsConfig {

    @Value("${aws.sns.accessKeyId}")
    private String accessKeyId;

    @Value("${aws.sns.secretKey}")
    private String secretKey;

    @Value("${aws.sns.region}")
    private String region;

    @Value("${aws.sns.userPointUpdatesTopicArn}")
    private String userPointUpdatesTopicArn;

    @Value("${aws.sns.vendorPointUpdatesTopicArn}")
    private String vendorPointUpdatesTopicArn;

    @PostConstruct
    public void logConfig() {
        System.out.println("AWS SNS Configurations:");
        System.out.println("Access Key: " + accessKeyId);
        System.out.println("Region: " + region);
    }

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .region(Region.of(region))
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKeyId, secretKey)
                ))
                .build();
    }

    @Bean
    public String userPointUpdatesTopicArn() {
        return userPointUpdatesTopicArn;
    }

    @Bean
    public String vendorPointUpdatesTopicArn() {
        return vendorPointUpdatesTopicArn;
    }
}*/
