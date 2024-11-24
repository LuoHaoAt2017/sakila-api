package com.imooc.sakila.utils;

import com.imooc.sakila.constants.LogCode;

public class NoPermissionException extends RuntimeException {

    public NoPermissionException(LogCode logCode) {
        super(logCode.getMessage());
    }
}
