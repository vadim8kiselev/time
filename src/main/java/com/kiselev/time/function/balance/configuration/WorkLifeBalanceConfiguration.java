package com.kiselev.time.function.balance.configuration;

import com.kiselev.time.function.balance.WorkLifeBalanceService;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkLifeBalanceConfiguration {

    @Bean
    public WorkLifeBalanceService workLifeBalanceService(AuthenticationService authenticationService,
                                                         ProfileService profileService) {
        return new WorkLifeBalanceService(
                authenticationService,
                profileService
        );
    }
}
