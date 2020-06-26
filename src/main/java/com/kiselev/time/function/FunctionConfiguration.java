package com.kiselev.time.function;

import com.kiselev.time.function.balance.configuration.WorkLifeBalanceConfiguration;
import com.kiselev.time.function.calculator.configuration.CalculatorServiceConfiguration;
import com.kiselev.time.function.usage.configuration.UsageCostConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
        CalculatorServiceConfiguration.class,
        WorkLifeBalanceConfiguration.class,
        UsageCostConfiguration.class
})
public class FunctionConfiguration {

}
