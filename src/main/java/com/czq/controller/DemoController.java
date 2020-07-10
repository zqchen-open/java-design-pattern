package com.czq.controller;

import com.czq.strategy.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private ResponseHandler responseHandler;

    @GetMapping("/strategy/{clientType}")
    public String strategy(@PathVariable("clientType") String clientType) {
        System.out.println("-------ok");
        responseHandler.handle(clientType, "", "");
        return "ok";
    }
}

