package com.acmlab.restservicetest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sample_service")
public class SimpleRestService {
    
    @GetMapping("/elements")
    public List<String> listElements() {
        return List.of("elemetn1", "element2", "element3");
    }


    @GetMapping("/element/{name}")
    public String element(@PathVariable String name) {
        return "Loading element " + name;
    }

}
