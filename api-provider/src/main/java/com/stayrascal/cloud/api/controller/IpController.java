package com.stayrascal.cloud.api.controller;

import com.stayrascal.cloud.api.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ip")
public class IpController {
    @Autowired
    private ContainerService containerService;

    @RequestMapping
    public String getIp() {
        return containerService.getIp();
    }
}
