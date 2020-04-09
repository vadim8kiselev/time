package com.kiselev.time.service.calculator.strategy;

import com.kiselev.time.model.constants.TimeConstants;
import com.kiselev.time.model.profile.Profile;
import com.kiselev.time.service.calculator.utils.CalculationUtils;

public class CalendarTimeStrategy {

    public Long calculate(Profile profile, Long price) {
        double netIncome = CalculationUtils.tax(
                profile.getSalary(),
                profile.getTax()
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
