package com.stayrascal.cloud.api.ribbon.resource;

import com.stayrascal.cloud.api.ribbon.client.ComputeClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    private final Logger logger = LoggerFactory.getLogger(ConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ComputeClient computeClient;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add() {
        logger.info("call config server");
        return restTemplate.getForEntity("http://CONFIGSERVER/add?a=10&b=20", String.class).getBody();
    }

    @RequestMapping(value = "/add2", method = RequestMethod.GET)
    public Integer add2() {
        logger.info("call config server by feign client");
        return computeClient.add(10, 20);
    }
}