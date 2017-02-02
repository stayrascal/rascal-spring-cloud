package com.stayrascal.cloud.api.dao;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class CustomerDaoImpl {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(groupKey = "customer-api-group", commandKey = "get-customer", fallbackMethod = "fallback")
    public String getCustomer(String id) {
        return restTemplate.getForObject("http://localhost/customers/{id}", String.class, id);
    }

    public String fallback() {
        return "This is a fallback value";
    }
}
