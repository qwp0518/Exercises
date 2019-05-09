package com.example.exception1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UsersController {

    @RequestMapping("/showUsers")
    public String showUsers(){
        String str = null;
        str.length();
        return "index";
    }

    @RequestMapping("/showUsers2")
    public String showUsers2(){
        int a = 10 / 0;
        return "index";
    }
}
