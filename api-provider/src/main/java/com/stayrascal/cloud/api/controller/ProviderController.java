package com.stayrascal.cloud.api.controller;

import com.stayrascal.cloud.api.service.ContainerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProviderController.class);

    @Autowired
    private ContainerService containerService;

    @RequestMapping("/log-error")
    @ResponseStatus(reason = "Error is triggered")
    public String logError() {
        LOGGER.error("There is an error happened");
        return "";
    }
}
