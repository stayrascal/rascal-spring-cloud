package com.stayrascal.api.consul;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("consul")
public class ConsulProperties {
    private String prop = "default value";

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }
}
