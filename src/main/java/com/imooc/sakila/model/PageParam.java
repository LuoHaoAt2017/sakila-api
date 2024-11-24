package com.imooc.sakila.model;

import lombok.Data;

import javax.validation.constraints.Positive;

@Data
public class PageParam {
    @Positive(message = "pageSize必须是正数")
    private int pageSize;

    @Positive(message = "page必须是正数")
    private int pageNum;

    private String asc;

    private String desc;
}
