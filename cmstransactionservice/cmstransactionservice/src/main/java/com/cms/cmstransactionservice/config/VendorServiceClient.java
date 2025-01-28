package com.cms.cmstransactionservice.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cms-vendor-service")
public interface VendorServiceClient {
    @GetMapping("/vendors/validate/{vendorId}")
    boolean validateVendor(@PathVariable String vendorId);
}
