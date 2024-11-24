package com.imooc.springboot.model.vendor;

import lombok.Data;

@Data
public class AddVendor {
    private String vendName;

    private String vendAddress;

    private String vendState;

    private String vendCity;

    private String vendCountry;

    private String vendZip;
}
