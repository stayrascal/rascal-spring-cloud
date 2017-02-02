package com.stayrascal.cloud.api.controller;

import com.stayrascal.cloud.api.service.Containerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ip")
public class IpController {
    @Autowired
    private Containerservice containerservice;

    @RequestMapping
    public String getIp() {
        return containerservice.getIp();
    }
}
