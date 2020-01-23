package com.kiselev.time.service;

import com.kiselev.time.service.calculator.CalculatorService;
import com.kiselev.time.service.calculator.strategy.CalendarDateStrategy;
import com.kiselev.time.service.calculator.strategy.CalendarTimeStrategy;
import com.kiselev.time.service.calculator.strategy.CleanTimeStrategy;
import com.kiselev.time.service.calculator.strategy.PercentStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public CalculatorService calculatorService() {
        return new CalculatorService(
                calendarDateStrategy(),
                calendarTimeStrategy(),
                cleanTimeStrategy(),
                percentStrategy()
        );
    }

    @Bean
    public CalendarDateStrategy calendarDateStrategy() {
        return new CalendarDateStrategy();
    }

    @Bean
    public CalendarTimeStrategy calendarTimeStrategy() {
        return new CalendarTimeStrategy();
    }

    @Bean
    public CleanTimeStrategy cleanTimeStrategy() {
        return new CleanTimeStrategy();
    }

    @Bean
    public PercentStrategy percentStrategy() {
        return new PercentStrategy();
    }
}
