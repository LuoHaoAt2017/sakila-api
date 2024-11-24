package com.imooc.sakila.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {
    /**
     * 成功
     */
    SUCCESS("U000000", "SUCCESS"),
    /**
     * 失败
     */
    FAILED("U000001", "FAILED");
    /**
     * 返回编码
     */
    private String code;

    /**
     * 编码描述
     */
    private String description;
}
