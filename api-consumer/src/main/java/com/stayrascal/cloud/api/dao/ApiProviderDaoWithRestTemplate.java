package com.stayrascal.cloud.api.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ApiProviderDaoWithRestTemplate {
    @Autowired
    private RestTemplate restTemplate;

    public String getInfo() {
        return restTemplate.getForObject("http://api-provider/info", String.class);
    }
}
