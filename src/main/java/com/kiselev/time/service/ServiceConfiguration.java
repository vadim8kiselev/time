package com.kiselev.time.service;

import com.kiselev.time.service.calculator.CalculatorService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorService();
    }
}
