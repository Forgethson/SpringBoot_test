package com.forgethson.springboot_test.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/start")
public class StartController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Welcome to the world of Spring Boot!";
    }
}
