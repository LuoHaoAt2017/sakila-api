package com.imooc.springboot.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionUtil {

    ExceptionUtil() {
    }

    public static String getStackTrace(Exception e) {
        try (StringWriter sw = new StringWriter(); PrintWriter pw = new PrintWriter(sw)) {
            e.printStackTrace(pw);
            return "\r\n" + sw.toString() + "\r\n";
        } catch (Exception ex) {
            return "Get Exception Stack Trace Failed!";
        }
    }
}
