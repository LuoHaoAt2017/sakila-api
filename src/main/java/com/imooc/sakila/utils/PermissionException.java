package com.imooc.sakila.utils;

import com.imooc.sakila.enums.LogCode;

public class PermissionException extends RuntimeException {

    public PermissionException(LogCode logCode) {
        super(logCode.getMessage());
    }
}
