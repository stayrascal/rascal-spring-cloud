package com.stayrascal.cloud.api.ribbon.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("configserver")
public interface ComputeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b);
}
