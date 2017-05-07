package com.stayrascal.cloud.api.controller;

import com.stayrascal.cloud.api.dao.ApiProviderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/consul")
public class ConsulController {

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private ApiProviderDao apiProviderDao;

    @Autowired
//    @LoadBalanced
    private RestTemplate loadBalanceRestTemplate;

    @Autowired
//    @LoadBalanced
    private RestTemplate restTemplate;

    /**
     * Choose a service from all the services
     */
    @RequestMapping("/discover")
    public String discover() {
        return loadBalancerClient.choose("api-provider").getUri().toString();
    }

    @RequestMapping("/services")
    public Object services() {
        return discoveryClient.getInstances("api-provider");
    }

    @RequestMapping(value = "/call", produces = "application/json")
    public String call() {
        return apiProviderDao.getInfo();
    }

    @RequestMapping(value = "/call/ip", produces = "application/json")
    public String callIp() {
        return apiProviderDao.getIp();
    }

    @RequestMapping(value = "/call/error", produces = "application/json")
    public String triggerError() {
        return apiProviderDao.triggerError();
    }

    @RequestMapping(value = "/call1", produces = "application/json")
    public String callUsingLoadBalancedRestTemplate() {
        return loadBalanceRestTemplate.getForObject("http://api-provider/info", String.class);
    }

    @RequestMapping(value = "/call2", produces = "application/json")
    public String callUsingRestTemplate() {
        return restTemplate.getForObject("http://api-provider/info", String.class);
    }
}
