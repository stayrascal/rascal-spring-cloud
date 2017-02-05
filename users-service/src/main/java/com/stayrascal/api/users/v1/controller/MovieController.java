package com.stayrascal.api.users.v1.controller;

import com.stayrascal.api.users.v1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit", required = false) Integer limit){
        return movieService.graph(limit);
    }
}
