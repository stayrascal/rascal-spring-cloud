package com.stayrascal.api.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Service {

    @HystrixCommand
    public String hello() {
        return "Hello";
    }
}
