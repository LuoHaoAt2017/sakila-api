package com.imooc.sakila.utils;

import com.imooc.sakila.enums.LogCode;

public class NoPermissionException extends RuntimeException {

    public NoPermissionException(LogCode logCode) {
        super(logCode.getMessage());
    }
}
