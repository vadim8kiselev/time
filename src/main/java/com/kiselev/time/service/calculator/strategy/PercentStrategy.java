package com.kiselev.time.service.calculator.strategy;

import com.kiselev.time.model.TimeConstants;
import com.kiselev.time.model.profile.Profile;

public class PercentStrategy extends CalendarTimeStrategy {

    public Long calculate(Profile profile, Long price) {
        Integer age = profile.getAge();

        if (age != null) {
            long timeToBuy = super.calculate(profile, price);

            long secondsToLive = age *
                    TimeConstants.DAYS * TimeConstants.HOURS * TimeConstants.MINUTES * TimeConstants.SECONDS;

            return Math.round((timeToBuy + 0.0) / secondsToLive * 100);
        }

        return null;
    }
}