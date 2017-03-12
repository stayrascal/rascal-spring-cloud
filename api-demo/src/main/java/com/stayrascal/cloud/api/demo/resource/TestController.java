package com.stayrascal.cloud.api.demo.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${from:default}")
    private String from;

    @Value("${to:default}")
    private String to;

    @RequestMapping("/from")
    public String from(){
        return "From: " + this.from + " To: " + this.to;
    }
}
