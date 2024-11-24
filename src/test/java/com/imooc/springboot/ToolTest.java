package com.imooc.springboot;

import com.imooc.springboot.annotation.NeedTest;
import com.imooc.springboot.annotation.RoomTest;
import com.imooc.springboot.aspectJ.AspectTest;
import com.imooc.springboot.aspectJ.PreGreetingAspect;
import com.imooc.springboot.service.ForumService;
import com.imooc.springboot.service.NaiveWaiter;
import com.imooc.springboot.service.NaughtyWaiter;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;

import java.lang.reflect.Method;

public class ToolTest {

    @Test
    public void test1() {
        Class<ForumService> clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (Method method: methods) {
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if(nt != null) {
                if (nt.value()) {
                    System.out.println(method.getName() + "需要测试");
                } else {
                    System.out.println(method.getName() + "不需要测试");
                }
            }
        }
    }

    @Test
    public void test2() {
        Class<ForumService> clazz = ForumService.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            RoomTest rt = method.getAnnotation(RoomTest.class);
            if (rt != null) {
                String roomInfo = rt.roomCode() + rt.roomName() + rt.roomType();
                System.out.println(method.getName() + " " + roomInfo);
            }
        }
    }

    @Test
    public void test3() {
        NaiveWaiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectTest.class);
        NaiveWaiter proxy = factory.getProxy();
        proxy.greetTo("John");
    }

    @Test
    public void test4() {
        NaughtyWaiter target = new NaughtyWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(AspectTest.class);
        NaughtyWaiter proxy = factory.getProxy();
        proxy.greetTo("Jack");
    }
}
