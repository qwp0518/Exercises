package com.example.eurekaribbonclient.controller;

import com.example.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonController {
    @Autowired
    private RibbonService ribbonService;

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    public String hi(@RequestParam(required = false,defaultValue = "william")String name){
        return ribbonService.hi(name);

    }
}
