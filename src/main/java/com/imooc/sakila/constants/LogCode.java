package com.imooc.sakila.constants;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public enum LogCode implements ILogCode {
    SUCCESS("U0000", "操作成功"),
    FAILURE("U0001", "系统错误"),
    UNKNOW("U0002", "未知错误"),
    NO_PERMISSION("U0401", "没有权限");

    @Getter
    private String code;

    @Getter
    @Setter
    private String message;

    LogCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public ILogCode getLogCode(String value) {
        LogCode messageCode = Arrays.stream(LogCode.values()).parallel().filter(e -> e.code == value).findFirst().orElse(LogCode.FAILURE);
        return messageCode;
    }
}
