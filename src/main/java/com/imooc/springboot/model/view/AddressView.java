package com.imooc.springboot.model.view;

import lombok.Data;

@Data
public class AddressView {
    private Integer addressId;

    private String address;

    private String district;

    private String city;

    private String country;

    private String postCode;

    private String phone;

    private byte[] location;
}
