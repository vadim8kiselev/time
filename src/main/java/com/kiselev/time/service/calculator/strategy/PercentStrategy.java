package com.kiselev.time.service.calculator.strategy;

import com.kiselev.time.model.profile.Profile;
import com.kiselev.time.service.calculator.utils.CalculationUtils;

public class PercentStrategy {

    private final CalendarTimeStrategy calendarTimeStrategy;

    public PercentStrategy(CalendarTimeStrategy calendarTimeStrategy) {
        this.calendarTimeStrategy = calendarTimeStrategy;
    }

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