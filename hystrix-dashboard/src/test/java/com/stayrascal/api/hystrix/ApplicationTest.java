package com.stayrascal.api.hystrix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration(exclude = FreeMarkerAutoConfiguration.class)
@EnableHystrix
@RestController
public class ApplicationTest {

    @Autowired
    private Service service;

    @Bean
    public Service service() {
        return new Service();
    }

    @RequestMapping("/")
    public String slash() {
        return service.hello();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApplicationTest.class, args);
    }


}