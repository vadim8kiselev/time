package com.kiselev.time.function.calculator.strategy;

import com.kiselev.time.model.constants.TimeConstants;
import com.kiselev.time.function.calculator.utils.CalculationUtils;
import com.kiselev.time.model.dto.internal.Profile;

public class CalendarTimeStrategy {

    public Long calculate(Profile profile, Long price) {
        double income = CalculationUtils.sumIncomes(
                profile.getIncomes()
        );

        double netIncome = CalculationUtils.subtractAverageSpending(
                profile,
                income
        );

        double netAnnualIncome = CalculationUtils.annualIncome(netIncome);
        long targetPeriodInSeconds = CalculationUtils.daysToSeconds(
                daysInTargetPeriod()
        );
        double moneyPerSecond = netAnnualIncome / targetPeriodInSeconds;
        return CalculationUtils.priceToSeconds(price, moneyPerSecond);
    }

    protected int daysInTargetPeriod() {
        return TimeConstants.DAYS_IN_YEAR;
    }
}
