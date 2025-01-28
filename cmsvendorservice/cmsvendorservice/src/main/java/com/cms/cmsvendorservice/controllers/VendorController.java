package com.cms.cmsvendorservice.controllers;

import com.cms.cmsvendorservice.DTO.VendorDto;
import com.cms.cmsvendorservice.model.Vendor;
import com.cms.cmsvendorservice.model.VendorMonthlyPointsBalance;
import com.cms.cmsvendorservice.service.VendorService;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/register")
public class VendorController {

    private static final Logger logger = LoggerFactory.getLogger(VendorController.class);

    @Autowired
    private VendorService vendorService;
    @PostMapping(value = "/vendor",consumes = "application/json")
    public ResponseEntity<Vendor> registerVendor(@RequestBody VendorDto vendorDto){
        Vendor registeredVendor = vendorService.vendorRegister(vendorDto);
        return ResponseEntity.ok(registeredVendor);

    }

    @GetMapping("/{vendorId}/monthly-points")
    public ResponseEntity<List<VendorMonthlyPointsBalance>> getMonthlyPoints(@PathVariable String vendorId) {
    /*    try {
            // Parse the vendorId from String to long
            long vendorIdLong = Long.parseLong(vendorId);

            // Pass the parsed long to your service layer
            List<VendorMonthlyPointsBalance> balances = vendorService.getMonthlyPointsForVendor(vendorIdLong);

            // Return the response
            return ResponseEntity.ok(balances);
        } catch (NumberFormatException e) {
            // Handle the case where vendorId cannot be parsed into a long
            return ResponseEntity.badRequest().body(null);
        }*/
        /*List<VendorMonthlyPointsBalance> balances = vendorService.getMonthlyPointsForVendor(vendorId);
        return ResponseEntity.ok(balances);*/

        try {
            // Call the service method
            List<VendorMonthlyPointsBalance> balances = vendorService.getMonthlyPointsForVendor(vendorId);

            // Log the result to the console
            logger.info("Monthly points for vendor {}: {}", vendorId, balances);

            // Return the result in the API response
            return ResponseEntity.ok(balances);
        } catch (EntityNotFoundException e) {
            // Log and return an error response
            logger.error("Vendor not found: {}", vendorId);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            // Handle unexpected errors
            logger.error("Error fetching monthly points for vendor {}: {}", vendorId, e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
