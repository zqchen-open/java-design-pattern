package com.czq.controller;

import com.czq.strategy.StrategyHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private StrategyHandler strategyHandler;

    @GetMapping("/strategy/{clientType}")
    public String strategy(@PathVariable("clientType") String clientType) {
        System.out.println("-------ok");
        strategyHandler.handle(clientType, "", "");
        return "ok";
    }
}

