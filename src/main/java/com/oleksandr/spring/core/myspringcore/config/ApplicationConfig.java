package com.oleksandr.spring.core.myspringcore.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.oleksandr.spring.core.myspringcore")
@EnableAspectJAutoProxy
public class ApplicationConfig {

}
