package com.oleksandr.spring.core.myspringcore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oleksandr.spring.core.myspringcore.apsect.Countable;

@Service
public class OutputService {
    private final GreetingService greetingService;
    private final TimeService timeService;
    @Value("${app.name}")
    private String name;


    public OutputService(GreetingService greetingService, TimeService timeService) {
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    @Countable
    public void generateOutput() {
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }
}
