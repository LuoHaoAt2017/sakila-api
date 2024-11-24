package com.imooc.springboot.constants;

public interface ILogCode {
    String getCode();

    String getMessage();

    ILogCode getLogCode(String value);
}
