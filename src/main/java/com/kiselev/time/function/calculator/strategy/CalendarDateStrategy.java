package com.kiselev.time.function.calculator.strategy;

import com.kiselev.time.model.dto.internal.Profile;

import java.sql.Date;
import java.time.Instant;

public class CalendarDateStrategy extends CalendarTimeStrategy {

    public Long calculate(Profile profile, Long price) {
        try {
            long secondsToBuy = super.calculate(profile, price);
            return Date.from(
                    Instant.now()
                            .plusSeconds(secondsToBuy)
            ).getTime();
        } catch (ArithmeticException exception) {
            return null;
        }
    }
}