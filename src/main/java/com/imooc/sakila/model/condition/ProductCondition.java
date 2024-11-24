package com.imooc.springboot.model.condition;
import com.imooc.springboot.model.PageParam;
import lombok.Data;

@Data
public class ProductCondition extends PageParam {
    private String prodName;
}
