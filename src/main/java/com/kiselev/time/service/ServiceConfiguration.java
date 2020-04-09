package com.kiselev.time.service;

import com.kiselev.time.service.calculator.configuration.CalculatorServiceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {CalculatorServiceConfiguration.class})
public class ServiceConfiguration {
}
