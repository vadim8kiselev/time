package com.kiselev.time.function.calculator.strategy;

import com.kiselev.time.function.calculator.utils.CalculationUtils;
import com.kiselev.time.model.dto.Profile;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PercentStrategy {

    private final CalendarTimeStrategy calendarTimeStrategy;

    public Double calculate(Profile profile, Long price) {
        Integer age = profile.getAge();
        if (age != null) {
            long timeToBuy = calendarTimeStrategy.calculate(profile, price);

            long pastSeconds = CalculationUtils.yearsToSeconds(age);

            return CalculationUtils.percents(timeToBuy, pastSeconds);
        }
        return null;
    }
}