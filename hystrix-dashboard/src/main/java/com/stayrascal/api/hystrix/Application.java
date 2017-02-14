package com.stayrascal.api.hystrix;

import com.stayrascal.api.hystrix.stream.MockStreamServlet;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Controller
@EnableHystrixDashboard
public class Application extends SpringBootServletInitializer {

    @RequestMapping("/")
    public String name(){
        return "forward:/hystrix";
    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class).web(true);
    }

    @Bean
    public ServletRegistrationBean mockStreamServlet() {
        return new ServletRegistrationBean(new MockStreamServlet(), "/mock.stream");
    }
}
