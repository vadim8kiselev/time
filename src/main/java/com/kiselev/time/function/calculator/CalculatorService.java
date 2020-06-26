package com.kiselev.time.function.calculator;

import com.kiselev.time.function.AbstractFunction;
import com.kiselev.time.function.calculator.strategy.CalendarDateStrategy;
import com.kiselev.time.function.calculator.strategy.CalendarTimeStrategy;
import com.kiselev.time.function.calculator.strategy.CleanTimeStrategy;
import com.kiselev.time.function.calculator.strategy.PercentStrategy;
import com.kiselev.time.model.dto.db.Profile;
import com.kiselev.time.model.response.CalculatorResponse;
import com.kiselev.time.service.authentication.AuthenticationService;
import com.kiselev.time.service.profile.ProfileService;

public class CalculatorService extends AbstractFunction {

    private final CalendarDateStrategy calendarDateStrategy;

    private final CalendarTimeStrategy calendarTimeStrategy;

    private final CleanTimeStrategy cleanTimeStrategy;

    private final PercentStrategy percentStrategy;

    public CalculatorService(AuthenticationService authenticationService,
                             ProfileService profileService,
                             CalendarDateStrategy calendarDateStrategy,
                             CalendarTimeStrategy calendarTimeStrategy,
                             CleanTimeStrategy cleanTimeStrategy,
                             PercentStrategy percentStrategy) {
        super(authenticationService, profileService);
        this.calendarDateStrategy = calendarDateStrategy;
        this.calendarTimeStrategy = calendarTimeStrategy;
        this.cleanTimeStrategy = cleanTimeStrategy;
        this.percentStrategy = percentStrategy;
    }

    public CalculatorResponse calculateTime(Long price) {
        Profile profile = profile();

        return new CalculatorResponse(
                calendarDateStrategy.calculate(profile, price),
                calendarTimeStrategy.calculate(profile, price),
                cleanTimeStrategy.calculate(profile, price),
                percentStrategy.calculate(profile, price)
        );
    }
}
