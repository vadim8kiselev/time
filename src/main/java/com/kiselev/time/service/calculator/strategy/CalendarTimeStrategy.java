package com.kiselev.time.service.calculator.strategy;

import com.kiselev.time.model.TimeConstants;
import com.kiselev.time.model.profile.Profile;

public class CalendarTimeStrategy {

    public Long calculate(Profile profile, Long price) {
        double salary = profile.getSalary() * ((100 - profile.getTax() + 0.0) / 100);

        double moneyPerSecond = (salary * TimeConstants.MONTHS + 0.0) /
                (workingDays() * TimeConstants.HOURS * TimeConstants.MINUTES * TimeConstants.SECONDS);

        return Math.round((price + 0.0) / moneyPerSecond);
    }

    protected Integer workingDays() {
        return TimeConstants.DAYS;
    }
}
