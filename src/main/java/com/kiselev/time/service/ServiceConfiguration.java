package com.kiselev.time.service;

import com.kiselev.time.model.session.TimeSession;
import com.kiselev.time.service.calculator.configuration.CalculatorServiceConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
@Import(value = {CalculatorServiceConfiguration.class})
public class ServiceConfiguration {

    @Bean
    @Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public TimeSession timeSession() {
        return new TimeSession();
    }
}
