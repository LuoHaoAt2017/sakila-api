package com.imooc.sakila.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum LogCode {
    SUCCESS("U000000", "操作成功"),
    FAILURE("U000001", "系统错误"),
    UNKNOW("U000002", "未知错误"),
    NO_PERMISSION("U000401", "没有权限");


    private final String code;

    private final String message;

    LogCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public LogCode getLogCode(String value) {
        return Arrays.stream(LogCode.values()).parallel().filter(e -> e.code.equals(value)).findFirst().orElse(LogCode.FAILURE);
    }
}
