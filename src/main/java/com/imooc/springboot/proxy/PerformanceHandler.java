package com.imooc.springboot.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler {
    private Object target;

    public PerformanceHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        PerformanceMonitor.begin(target.getClass().getName() + "." + method.getName());
        Object result = method.invoke(target, args); // 通过java反射机制间接调用目标对象的方法
        PerformanceMonitor.end(target.getClass().getName() + "." + method.getName());
        return result;
    }
}
