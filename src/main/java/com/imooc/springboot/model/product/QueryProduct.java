package com.imooc.springboot.model.product;

import lombok.Data;
import javax.validation.constraints.*;

/**
 * 经过格式化处理展示给视图层的model
 */
@Data
public class QueryProduct {

    @Positive(message = "pageSize必须是正数")
    private int pageSize;

    @Positive(message = "page必须是正数")
    private int page;
}
