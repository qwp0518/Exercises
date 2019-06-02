package com.example.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String greetings(@RequestParam String name){
        return "hi, " + name + " i am from port " + port;

    }
}
