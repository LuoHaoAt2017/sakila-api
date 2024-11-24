package com.imooc.springboot.exception;
import com.imooc.springboot.constants.ILogCode;
import com.imooc.springboot.utils.ExceptionUtil;
import lombok.Getter;

public class ServiceException extends RuntimeException {

    @Getter
    private String errorCode;

    @Getter
    private String errorMessage;

    @Getter
    private ILogCode logCode;

    public ServiceException(ILogCode logCode) {
        super(logCode.getMessage());
        this.logCode = logCode;
        this.errorCode = logCode.getCode();
        this.errorMessage = logCode.getMessage();
    }

    public ServiceException(ILogCode logCode, Exception e) {
        super(logCode.getMessage());
        this.logCode = logCode;
        this.errorCode = logCode.getCode();
        this.errorMessage = ExceptionUtil.getStackTrace(e);
    }
}
