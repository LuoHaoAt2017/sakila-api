package com.imooc.springboot.model.view;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductView {
    private Integer prodId;

    private String prodName;

    private BigDecimal prodPrice;

    private String prodDesc;

    private Integer vendId;

    private String vendName;

    private String vendCity;

    private String vendState;

    private String vendZip;

    private String vendCountry;

    private String vendAddress;
}
