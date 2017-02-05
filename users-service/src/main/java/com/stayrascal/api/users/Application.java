package com.stayrascal.api.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
//@EnableDiscoveryClient
//@EnableHystrix
//@EnableZuulProxy
@EnableNeo4jRepositories(basePackages = "com.stayrascal.api.users.v1.repositories")
@EntityScan(basePackages = "com.stayrascal.api.users.v1.domain")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
