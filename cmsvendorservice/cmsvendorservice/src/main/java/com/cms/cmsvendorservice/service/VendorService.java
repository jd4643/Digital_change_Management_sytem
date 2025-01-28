package com.cms.cmsvendorservice.service;

import com.cms.cmsvendorservice.DTO.VendorDto;
import com.cms.cmsvendorservice.model.Vendor;
import com.cms.cmsvendorservice.model.VendorMonthlyPointsBalance;
import com.cms.cmsvendorservice.repository.VendorMonthlyPointsBalanceRepository;
import com.cms.cmsvendorservice.repository.VendorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class VendorService {


    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private VendorMonthlyPointsBalanceRepository vendorMonthlyPointsBalanceRepository;


    public Vendor vendorRegister(VendorDto vendorDto){
        Vendor vendor = new Vendor();
        vendor.setVendorId(vendorDto.getVendorId());
        vendor.setNameOfVendor(vendorDto.getNameOfVendor());

        return vendorRepository.save(vendor);
    }

    public void updateVendorPointsBalance(String vendorId,double points){

        Vendor vendor = vendorRepository.findByVendorId(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("Vendor not found"));

        // Get current month
        String currentMonth = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));

        // Find or create MonthlyPointsBalance for the current month
        VendorMonthlyPointsBalance monthlyBalance = vendor.vendorMonthlyPointsBalanceList().stream()
                .filter(balance -> balance.month().equals(currentMonth))
                .findFirst()
                .orElse(new VendorMonthlyPointsBalance(0,currentMonth,vendor));

        // Update points
        monthlyBalance.setPoints(monthlyBalance.points()+ points);

        // Save monthly balance and vendor
        vendor.vendorMonthlyPointsBalanceList().add(monthlyBalance);
        /*vendor.setVendorPointsBalance(vendor.getVendorPointsBalance() + points);*/

        vendorRepository.save(vendor);
    }


    public List<VendorMonthlyPointsBalance> getMonthlyPointsForVendor(String vendorId) {
        Vendor vendor = vendorRepository.findByVendorId(vendorId)
                .orElseThrow(() -> new EntityNotFoundException("Vendor not found"));
        /*long vendorIdLong = Long.parseLong(vendorId);*/
        return vendorMonthlyPointsBalanceRepository.findByVendorId(vendorId);
    }

    public boolean validateVendor(String vendorId){
        return vendorRepository.findByVendorId(vendorId).isPresent();
    }





}