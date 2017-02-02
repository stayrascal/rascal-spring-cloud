package com.stayrascal.cloud.api.configuration;

import com.stayrascal.cloud.api.service.Containerservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class ApplicationInfoConfiguration {

    @Autowired
    private Containerservice containerservice;

    @Autowired
    private Environment environment;

    public InfoContributor extendInfo() {
        return new InfoContributor() {
            @Override
            public void contribute(Info.Builder builder) {
                builder.withDetail("id", environment.getProperty("spring.application.name") + ":" + environment.getProperty("server.port", "8080"));
                builder.withDetail("ip", containerservice.getIp());
            }
        };
    }
}
