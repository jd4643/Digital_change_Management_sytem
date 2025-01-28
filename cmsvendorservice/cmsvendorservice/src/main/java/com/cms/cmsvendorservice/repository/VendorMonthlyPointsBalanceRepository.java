package com.cms.cmsvendorservice.repository;

import com.cms.cmsvendorservice.model.VendorMonthlyPointsBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorMonthlyPointsBalanceRepository extends JpaRepository<VendorMonthlyPointsBalance,Long> {

    @Query("SELECT vmp FROM VendorMonthlyPointsBalance vmp WHERE vmp.vendor.vendorId = :vendorId")
    List<VendorMonthlyPointsBalance> findByVendorId(@Param("vendorId") String vendorId);

    /*Optional<VendorMonthlyPointsBalance> findByVendorIdAndMonth(String vendorId, String month);*/
}