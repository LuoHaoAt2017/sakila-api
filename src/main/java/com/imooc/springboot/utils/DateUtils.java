package com.imooc.springboot.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";

    public static String now(String format) {
        return parseDateToStr(new Date(), format);
    }

    public static String parseDateToStr(Date time, String timeFormat) {
        DateFormat dateFormat = new SimpleDateFormat(timeFormat);
        return dateFormat.format(time);
    }
}
