package com.kiselev.time.function.day.configuration;

import com.kiselev.time.function.day.DayTimeService;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DayTimeConfiguration {

    @Bean
    public DayTimeService dayTimeService(AuthenticationService authenticationService,
                                         ProfileService profileService) {
        return new DayTimeService(
                authenticationService,
                profileService
        );
    }
}
