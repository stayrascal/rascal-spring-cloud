package com.stayrascal.cloud.api.gateway;

import com.netflix.zuul.ZuulFilter;
import com.stayrascal.cloud.api.gateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringCloudApplication
//@EnableSidecar
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public ZuulFilter accessFilter(){
        return new AccessFilter();
    }
}
