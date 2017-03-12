package com.stayrascal.cloud.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

@Service
public class Containerservice {
    private static final Logger LOGGER = LoggerFactory.getLogger(Containerservice.class);

    @Autowired
    private DiscoveryClient discoveryClient;

    public String getIp(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.error("Get IP address error", e);
            throw new RuntimeException(e);
        }
    }

    public String seviceUrl(){
        List<ServiceInstance> stores = discoveryClient.getInstances("STORES");
        if (stores != null && stores.size() > 0){
            return stores.get(0).getUri().toString();
        }
        return null;
    }
}
