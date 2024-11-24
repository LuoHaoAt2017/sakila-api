package com.imooc.springboot.service;

import com.imooc.springboot.annotation.NeedTest;

public class NaughtyWaiter implements Waiter {
    @Override
    @NeedTest
    public void greetTo(String clientName) {
        System.out.println("greetTo: " + clientName);
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("serveTo: " + clientName);
    }
}
