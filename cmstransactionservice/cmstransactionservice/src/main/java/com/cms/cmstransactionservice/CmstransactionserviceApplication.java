package com.cms.cmstransactionservice;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CmstransactionserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmstransactionserviceApplication.class, args);
	}

}
