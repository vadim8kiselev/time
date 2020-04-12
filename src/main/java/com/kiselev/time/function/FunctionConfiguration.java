package com.kiselev.time.function;

import com.kiselev.time.function.calculator.configuration.CalculatorServiceConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {CalculatorServiceConfiguration.class})
public class FunctionConfiguration {

}
