package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(HelloResource.HELLO_RESOURCE)
public class HelloResource {
    public static final String HELLO_RESOURCE = "/hello";
    @GetMapping
    public String hello(@RequestParam(value = "nom", defaultValue = "World") String nom) {
        return String.format("Hello %s!", nom);
    }

    @GetMapping("/bye")
    public String bye() {
        return String.format("Bye Bye");
    }
}


