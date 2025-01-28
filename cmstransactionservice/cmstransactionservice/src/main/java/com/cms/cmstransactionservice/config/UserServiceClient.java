package com.cms.cmstransactionservice.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "cms-user-service")
public interface UserServiceClient {
    @GetMapping("/users/validate/{accountNumber}")
    boolean validateAccount(@PathVariable String accountNumber);
}
