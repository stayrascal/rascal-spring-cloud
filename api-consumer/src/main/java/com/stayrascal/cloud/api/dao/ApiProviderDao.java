package com.stayrascal.cloud.api.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("api-provider")
public interface ApiProviderDao {

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    String getInfo();

    @RequestMapping(method = RequestMethod.GET, value = "/log-error")
    String triggerError();

    @RequestMapping(method = RequestMethod.GET, value = "/ip")
    String getIp();
}
