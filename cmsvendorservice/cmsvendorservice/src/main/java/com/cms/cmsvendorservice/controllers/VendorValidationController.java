package com.cms.cmsvendorservice.controllers;

import com.cms.cmsvendorservice.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendors")
public class VendorValidationController {

    @Autowired
    private VendorService vendorService;

    @GetMapping("/validate/{vendorId}")
    public ResponseEntity<Boolean> validateVendor(@PathVariable String vendorId) {
        boolean isValid = vendorService.validateVendor(vendorId);
        return ResponseEntity.ok(isValid);
    }
}
