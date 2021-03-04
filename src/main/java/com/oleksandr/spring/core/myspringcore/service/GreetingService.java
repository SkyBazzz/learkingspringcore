package com.oleksandr.spring.core.myspringcore.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.oleksandr.spring.core.myspringcore.apsect.Countable;
import com.oleksandr.spring.core.myspringcore.apsect.Loggable;

@Service
public class GreetingService {
    @Value("${app.greeting}")
    private String greeting;

    public GreetingService(){
    }

    @Loggable
    @Countable
    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
