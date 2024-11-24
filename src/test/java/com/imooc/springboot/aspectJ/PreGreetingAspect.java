package com.imooc.springboot.aspectJ;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 通过注解标识成一个切面
public class PreGreetingAspect {

    // 在目标类的greetTo()方法上织入前置增强，greetTo()方法可以携带任意入参，可以返回任何值。
    @Before("execution(* greetTo(..))") //定义切点和增强类型
    public void beforeGreetTo() { // 增强的横切逻辑
        System.out.println("how are you");
    }

    @After("execution(* serveTo(..))")
    public void afterServing() {
        System.out.println("looking forward to your next visit");
    }
}
