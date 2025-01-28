package com.cms.cmsvendorservice.DTO;


import org.springframework.stereotype.Component;

@Component
public class VendorDto {

    private String vendorId;
    private String nameOfVendor;


    public String getVendorId() {
        return vendorId;
    }

    @Override
    public String toString() {
        return "VendorDto{" +
                "vendor_id='" + vendorId + '\'' +
                ", vendor_name='" + nameOfVendor + '\'' +
                '}';
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public String getNameOfVendor() {
        return nameOfVendor;
    }

    public void setNameOfVendor(String nameOfVendor) {
        this.nameOfVendor = nameOfVendor;
    }

    public VendorDto() {
    }

    public VendorDto(String vendorId, String nameOfVendor) {
        this.vendorId = vendorId;
        this.nameOfVendor = nameOfVendor;
    }
}
