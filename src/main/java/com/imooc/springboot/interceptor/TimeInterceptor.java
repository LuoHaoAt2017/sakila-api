package com.imooc.springboot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    private ThreadLocal<Long> threadLocalStart = new ThreadLocal<>();
    private ThreadLocal<Long> threadLocalEnd = new ThreadLocal<>();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime = System.currentTimeMillis();
        threadLocalStart.set(startTime);
//        log.info("开始时间：{}", startTime);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long endTime = System.currentTimeMillis();
        threadLocalEnd.set(endTime);
//        log.info("结束时间：{}", endTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = threadLocalStart.get();
        long endTime = threadLocalEnd.get();
//        log.info("接口执行时间：{} 毫秒", endTime - startTime);
    }
}
