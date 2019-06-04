package com.example.eurekafeignclient;

import org.springframework.stereotype.Component;

@Component
public class HiError implements EurekaClientFeign {
    @Override
    public String sayHiFromEurekaClient(String name) {
        return "Sorry " + name + " Error!";
    }
}
