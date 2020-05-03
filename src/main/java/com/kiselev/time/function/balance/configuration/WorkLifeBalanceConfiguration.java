package com.kiselev.time.function.balance.configuration;

import com.kiselev.time.function.balance.WorkLifeBalanceService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkLifeBalanceConfiguration {

    @Bean
    public WorkLifeBalanceService workLifeBalanceService() {
        return new WorkLifeBalanceService();
    }
}
