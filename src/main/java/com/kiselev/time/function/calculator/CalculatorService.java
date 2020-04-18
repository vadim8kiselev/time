package com.kiselev.time.function.calculator;

import com.kiselev.time.model.dto.db.Profile;
import com.kiselev.time.model.response.CalculatorResponse;
import com.kiselev.time.function.calculator.strategy.CalendarDateStrategy;
import com.kiselev.time.function.calculator.strategy.CalendarTimeStrategy;
import com.kiselev.time.function.calculator.strategy.CleanTimeStrategy;
import com.kiselev.time.function.calculator.strategy.PercentStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CalculatorService {

    private CalendarDateStrategy calendarDateStrategy;

    private CalendarTimeStrategy calendarTimeStrategy;

    private CleanTimeStrategy cleanTimeStrategy;

    private PercentStrategy percentStrategy;

    public CalculatorResponse calculateTime(Profile profile, Long price) {
        return new CalculatorResponse(
                calendarDateStrategy.calculate(profile, price),
                calendarTimeStrategy.calculate(profile, price),
                cleanTimeStrategy.calculate(profile, price),
                percentStrategy.calculate(profile, price)
        );
    }
}
