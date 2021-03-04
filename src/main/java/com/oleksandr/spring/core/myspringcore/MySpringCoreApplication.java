package com.oleksandr.spring.core.myspringcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.oleksandr.spring.core.myspringcore.config.ApplicationConfig;
import com.oleksandr.spring.core.myspringcore.service.OutputService;

public class MySpringCoreApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i = 0; i < 5; i++) {
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
