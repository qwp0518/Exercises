package com.example.eurekafeignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client",configuration = FeignConfig.class)
public interface EurekaClientFeign {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromEurekaClient(@RequestParam(value = "name") String name);
}
