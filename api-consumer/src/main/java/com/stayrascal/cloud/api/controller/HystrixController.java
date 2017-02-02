package com.stayrascal.cloud.api.controller;

import com.stayrascal.cloud.api.service.hystrix.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/hystrix")
@RestController
public class HystrixController {

    @Autowired
    private HystrixService hystrixService;

    @RequestMapping("/success")
    public String success() {
        return hystrixService.success();
    }

    @RequestMapping("/fail")
    public String fail() {
        return hystrixService.fail();
    }
}
