package com.example.spring_boot_app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {


    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello world!";
    }

}
