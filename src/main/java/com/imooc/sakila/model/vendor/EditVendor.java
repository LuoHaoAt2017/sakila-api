package com.imooc.springboot.model.vendor;

import lombok.Data;

@Data
public class EditVendor {
    private Integer vendId;

    private String vendName;

    private String vendAddress;

    private String vendCity;

    private String vendState;

    private String vendZip;

    private String vendCountry;
}
