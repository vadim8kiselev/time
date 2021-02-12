package com.kiselev.time.function.usage.configuration;

import com.kiselev.time.function.usage.UsageCostService;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsageCostConfiguration {

    @Bean
    public UsageCostService usageCostService(AuthenticationService authenticationService,
                                             ProfileService profileService) {
        return new UsageCostService(
                authenticationService,
                profileService
        );
    }
}
