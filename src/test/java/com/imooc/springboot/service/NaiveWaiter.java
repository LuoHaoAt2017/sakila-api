package com.imooc.springboot.service;

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String clientName) {
        System.out.println("greetTo " + clientName + "...");
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("serveTo " + clientName + "...");
    }
}
