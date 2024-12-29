package com.imooc.sakila.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public List<String> hello(){
        String[] stringArray = {"Kimi", "AI", "Assistant"};
        return Arrays.asList(stringArray);
    }
}
