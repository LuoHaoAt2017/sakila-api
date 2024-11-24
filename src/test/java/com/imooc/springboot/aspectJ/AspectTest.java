package com.imooc.springboot.aspectJ;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AspectTest {

    // 被增强的目标类上的方法如果标注了@NeedTest注解，那么就会被织入后置增强逻辑
    @AfterReturning("@annotation(com.imooc.springboot.annotation.NeedTest)") // 增强类型 + 切点表达式
    public void needTestFun() { // 增强逻辑
        System.out.println("needTestFunc() executed");
    }
}
