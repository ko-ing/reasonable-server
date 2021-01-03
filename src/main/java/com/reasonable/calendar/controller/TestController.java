package com.reasonable.calendar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(value ="/hello-calendar")
    private String testController() {
        return "Hello Calendar";
    }
}
