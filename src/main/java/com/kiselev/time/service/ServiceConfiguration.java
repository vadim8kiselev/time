package com.kiselev.time.service;

import com.kiselev.time.repository.ProfileRepository;
import com.kiselev.time.security.encoder.SecurityEncoder;
import com.kiselev.time.security.jwt.JsonWebToken;
import com.kiselev.time.service.anonymity.AnonymityService;
import com.kiselev.time.service.authentication.AuthenticationService;
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
    public AuthenticationService authenticationService(JsonWebToken jsonWebToken,
                                                       ProfileService profileService,
                                                       SecurityEncoder securityEncoder,
                                                       AnonymityService anonymityService,
                                                       ValidationService validationService,
                                                       UserDetailsService userDetailsService,
                                                       AuthenticationManager authenticationManager) {
        return new AuthenticationService(
                jsonWebToken,
                profileService,
                securityEncoder,
                anonymityService,
                validationService,
                userDetailsService,
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
    public ValidationService validationService() {
        return new ValidationService();
    }

    @Bean
    public AnonymityService anonymityService() {
        return new AnonymityService();
    }
}
