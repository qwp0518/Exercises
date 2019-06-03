package com.example.eurekafeignclient.service;

import com.example.eurekafeignclient.EurekaClientFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HiService {

    @Autowired
    EurekaClientFeign eurekaclientfeign;

    public String sayHi(String name){
        return eurekaclientfeign.sayHiFromEurekaClient(name);
    }
}
