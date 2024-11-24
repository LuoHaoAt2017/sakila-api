package com.imooc.springboot.service;

import com.imooc.springboot.proxy.PerformanceHandler;
import com.imooc.springboot.service.impl.ProductServiceImpl;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Proxy;

@SpringBootTest
public class ProductServiceTest {

    @Test
    public void deleteProduct() throws Exception {
        ProductService productService = new ProductServiceImpl();
        productService.deleteProduct(12);
    }

    @Test
    public void proxyDeleteProduct() throws Exception {
        ProductService target = new ProductServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        ProductService proxy = (ProductService)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                handler);
        proxy.deleteProduct(12);
    }
}
