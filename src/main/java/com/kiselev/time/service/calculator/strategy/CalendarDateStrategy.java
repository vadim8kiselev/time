package com.kiselev.time.service.calculator.strategy;

import com.kiselev.time.model.profile.Profile;

import java.sql.Date;
import java.time.Instant;

public class CalendarDateStrategy extends CalendarTimeStrategy {

    public Long calculate(Profile profile, Long price) {
        long timeToBuy = super.calculate(profile, price);
        return Date.from(Instant.now().plusSeconds(timeToBuy)).getTime();
    }
}