package com.czq.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/student")
    public String getStudent() {
        System.out.println("-------ok");
        return "ok";
    }
}

