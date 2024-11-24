package com.imooc.springboot.model.product;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
public class ProductEdit {
    @NotNull(message = "产品Id不为空")
    private Integer prodId;

    @NotNull(message = "产品名称不为空")
    private String prodName;

    @Positive(message = "价格必须大于0")
    private BigDecimal prodPrice;

    /**
     * 产品描述
     * */
    private String prodDesc;

    /**
     * 供货商信息
     * */
    private Integer vendId;
}
