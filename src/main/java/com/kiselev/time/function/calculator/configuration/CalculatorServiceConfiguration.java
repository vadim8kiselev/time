package com.kiselev.time.function.calculator.configuration;

import com.kiselev.time.function.calculator.CalculatorService;
import com.kiselev.time.function.calculator.strategy.CalendarDateStrategy;
import com.kiselev.time.function.calculator.strategy.CalendarTimeStrategy;
import com.kiselev.time.function.calculator.strategy.CleanTimeStrategy;
import com.kiselev.time.function.calculator.strategy.PercentStrategy;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CalculatorServiceConfiguration {

    @Bean
    public CalculatorService calculatorService(AuthenticationService authenticationService,
                                               ProfileService profileService,
                                               CalendarDateStrategy calendarDateStrategy,
                                               CalendarTimeStrategy calendarTimeStrategy,
                                               CleanTimeStrategy cleanTimeStrategy,
                                               PercentStrategy percentStrategy) {
        return new CalculatorService(
                authenticationService,
                profileService,
                calendarDateStrategy,
                calendarTimeStrategy,
                cleanTimeStrategy,
                percentStrategy
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
    public PercentStrategy percentStrategy(CalendarTimeStrategy calendarTimeStrategy) {
        return new PercentStrategy(
                calendarTimeStrategy
        );
    }
}
