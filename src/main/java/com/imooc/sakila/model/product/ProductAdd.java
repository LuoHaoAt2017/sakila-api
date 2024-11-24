package com.imooc.springboot.model.product;

import lombok.Data;
import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#section-builtin-constraints
 */

@Data
public class ProductAdd {

    @NotNull(message = "产品名称不为空")
    private String prodName;

    @Positive(message = "价格必须大于0")
    private BigDecimal prodPrice;

    @NotEmpty(message = "产品描述不为空")
    private String prodDesc;

    /**
     * 供货商信息
     * */
    private Integer vendId;
}
