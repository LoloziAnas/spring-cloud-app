package com.lzitech.getewayservice.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CircuitBreakerController {
    @GetMapping("/defaultCovidStatistic")
    public Map<String,String> defaultCovidStatistic(){
        Map<String,String> data = new HashMap<>();
        data.put("msg","default Covid Statistic");

        return data;
    }
}
