package com.stayrascal.cloud.api.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfiguration {

    @Bean
    public RestTemplate restTemplate(){
        System.out.println("\n\n\n\n\n==============Create RestTemplate=========");
        return new RestTemplate();
    }
}
