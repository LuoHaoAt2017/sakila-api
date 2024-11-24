package com.imooc.springboot.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class MessageUtils {

    private static MessageSource messageSource;

    private static final Pattern PATTERN = Pattern.compile("(([A-Z|a-z|0-9])+(\\.)?)+");

    @Value("${common-config.location:en-US}")
    private static String configLang;

    public MessageUtils(MessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    public void setConfigLang(String configLang) {
        MessageUtils.configLang = configLang;
    }

    public String getConfigLang() {
        return MessageUtils.configLang;
    }

    public static String processMessage(String message, Object... args) {
        return processMessage(message, LocaleContextHolder.getLocale(), args);
    }

    public static String processMessage(String message, Locale locale, Object... args) {
        Matcher matcher = PATTERN.matcher(message);
        if (matcher.matches()) {
            message = MessageUtils.get(message, locale, args);
        }
        return message;
    }

    public static String get(String msgKey, Locale locale, Object... args) {
        try {
            return messageSource.getMessage(msgKey, args, locale);
        } catch (Exception e) {
            LogUtil.logDevWarn("获取国际化语言异常");
            return msgKey;
        }
    }
}
