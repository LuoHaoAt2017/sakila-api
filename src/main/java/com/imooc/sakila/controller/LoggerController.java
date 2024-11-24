package com.imooc.springboot.controller;

import com.imooc.springboot.utils.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/logs")
public class LoggerController {

    @GetMapping(value = "/test")
    public boolean test() {
        LogUtil.logDevInfo("this is a info mesg");
        LogUtil.logDevDebug("this is a debug mesg");
        LogUtil.logDevWarn("this is a warn mesg");
        LogUtil.logDevError("this is a error mesg");
        return true;
    }
}
