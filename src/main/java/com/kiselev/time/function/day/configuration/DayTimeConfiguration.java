package com.kiselev.time.function.day.configuration;

import com.kiselev.time.function.day.DayTimeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DayTimeConfiguration {

    @Bean
    public DayTimeService dayTimeService() {
        return new DayTimeService();
    }
}
