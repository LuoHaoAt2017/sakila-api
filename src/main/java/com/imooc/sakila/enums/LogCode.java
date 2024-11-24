package com.imooc.sakila.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum LogCode {
    SUCCESS("U0000", "操作成功"),
    FAILURE("U0001", "系统错误"),
    UNKNOW("U0002", "未知错误"),
    NO_PERMISSION("U0401", "没有权限");


    private final String code;

    private final String message;

    LogCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public LogCode getLogCode(String value) {
        return Arrays.stream(LogCode.values()).parallel().filter(e -> e.code == value).findFirst().orElse(LogCode.FAILURE);
    }
}
