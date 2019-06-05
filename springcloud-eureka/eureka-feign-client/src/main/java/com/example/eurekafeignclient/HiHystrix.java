package com.example.eurekafeignclient;

import org.springframework.stereotype.Component;

@Component
public class HiHystrix implements EurekaClientFeign{
    @Override
    public String sayHiFromEurekaClient(String name) {
        return "Hi " + name + " sorry,error!";
    }
}
