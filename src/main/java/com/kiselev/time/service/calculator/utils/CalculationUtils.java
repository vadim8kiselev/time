package com.kiselev.time.service.calculator.utils;

import com.kiselev.time.model.constants.TimeConstants;

public class CalculationUtils {

    private static final double DOUBLE_TAIL = .0;

    public static double percents(long lowerValue, long higherValue) {
        double percents = (lowerValue + DOUBLE_TAIL) / higherValue * 100;
        return (Math.round(percents * 100) + DOUBLE_TAIL) / 100;
    }

    public static long priceToSeconds(long dividend, double divider) {
        return Math.round((dividend + DOUBLE_TAIL) / divider);
    }

    public static double tax(long salary, int tax) {
        return salary * ((100 - tax + DOUBLE_TAIL) / 100) + DOUBLE_TAIL;
    }

    public static double annualIncome(double income) {
        return income * TimeConstants.MONTHS_IN_YEAR + DOUBLE_TAIL;
    }

    public static long yearsToSeconds(int numberOfYears) {
        return numberOfYears *
                TimeConstants.DAYS_IN_YEAR *
                TimeConstants.HOURS_IN_DAY *
                TimeConstants.MINUTES_IN_HOUR *
                TimeConstants.SECONDS_IN_MINUTE;
    }

    public static long daysToSeconds(int numberOfDays) {
        return numberOfDays *
                TimeConstants.HOURS_IN_DAY *
                TimeConstants.MINUTES_IN_HOUR *
                TimeConstants.SECONDS_IN_MINUTE;
    }
}
