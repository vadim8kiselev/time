package com.kiselev.time.service;

import com.kiselev.time.repository.ProfileRepository;
import com.kiselev.time.security.encoder.SecurityEncoder;
import com.kiselev.time.service.anonymity.AnonymityService;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.preparator.DataPreparator;
import com.kiselev.time.service.profile.ProfileService;
import com.kiselev.time.service.validation.ValidationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class ServiceConfiguration {

    @Bean
    @Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public AuthenticationService authenticationService(ProfileService profileService,
                                                       SecurityEncoder securityEncoder,
                                                       AnonymityService anonymityService,
                                                       ValidationService validationService,
                                                       AuthenticationManager authenticationManager) {
        return new AuthenticationService(
                profileService,
                securityEncoder,
                anonymityService,
                validationService,
                authenticationManager
        );
    }

    @Bean
    public ProfileService profilerService(ProfileRepository profileRepository,
                                          SecurityEncoder securityEncoder) {
        return new ProfileService(
                profileRepository,
                securityEncoder
        );
    }

    @Bean
    public DataPreparator dataPreparator() {
        return new DataPreparator();
    }

    @Bean
    public ValidationService validationService() {
        return new ValidationService();
    }

    @Bean
    public AnonymityService anonymityService() {
        return new AnonymityService();
    }
}
