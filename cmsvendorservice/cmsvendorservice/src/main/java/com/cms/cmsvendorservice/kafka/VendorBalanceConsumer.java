/*
package com.cms.cmsvendorservice.kafka;

import com.cms.cmsvendorservice.model.VendorPointUpdateMessage;
import com.cms.cmsvendorservice.model.Vendor;
import com.cms.cmsvendorservice.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VendorBalanceConsumer {

    @Autowired
    private VendorRepository vendorRepository;

    @KafkaListener(topics = "vendor-balance-updates", groupId = "vendor-service-group")
    public void updateVendorBalance(VendorPointUpdateMessage message) {
        Optional<Vendor> vendorOpt = vendorRepository.findByVendorId(message.getVendorId());
        if (vendorOpt.isPresent()) {
            Vendor vendor = vendorOpt.get();
            vendor.setVendorPointsBalance(vendor.getVendorPointsBalance() + message.change());
            vendorRepository.save(vendor);
        }
    }
}
*/
