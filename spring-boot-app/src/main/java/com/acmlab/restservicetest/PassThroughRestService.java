package com.acmlab.restservicetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/pass_through")
public class PassThroughRestService {

    @Autowired
    RestTemplate restTemplate;

    String uri = "http://localhost:8000";

    @GetMapping("/list")
    public Object listFiles() {
        Object response = restTemplate.getForObject(uri+"/users", Object.class);
        return response;
    }


    @GetMapping("/element/{name}")
    public String element(@PathVariable String name) {

        return "Loading element " + name;
    }

}
