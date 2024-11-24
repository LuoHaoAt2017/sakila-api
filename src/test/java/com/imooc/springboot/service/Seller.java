package com.imooc.springboot.service;

public interface Seller {
    int sell(String goods, String clientName);
    int showGoods(String goods);
}
