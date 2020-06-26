package com.kiselev.time.function.usage.configuration;

import com.kiselev.time.function.usage.UsageCostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsageCostConfiguration {

    @Bean
    public UsageCostService usageCostService() {
        return new UsageCostService();
    }
}
