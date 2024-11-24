package com.imooc.springboot.utils;
import com.imooc.springboot.constants.LogCode;
import org.slf4j.Logger;
import lombok.Data;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Data
public class LogUtil {

    private static final Logger infoLogger = LoggerFactory.getLogger("infoLogger");

    private static final Logger warnLogger = LoggerFactory.getLogger("warnLogger");

    private static final Logger debugLogger = LoggerFactory.getLogger("debugLogger");

    private static final Logger errorLogger = LoggerFactory.getLogger("errorLogger");

    public static void logDevError(LogCode logCode) {
        LogUtil.logDevError(logCode.getMessage());
    }

    public static void logDevInfo(String message) {
        if (infoLogger.isInfoEnabled()) {
            infoLogger.info(message);
        }
    }

    public static void logDevDebug(String message) {
        if (debugLogger.isDebugEnabled()) {
            debugLogger.debug(message);
        }
    }

    public static void logDevWarn(String message) {
        if (debugLogger.isWarnEnabled()) {
            warnLogger.warn(message);
        }
    }

    public static void logDevError(String message) {
        if (errorLogger.isErrorEnabled()) {
            errorLogger.error(message);
        }
    }
}
