package com.kiselev.time.service.calculator.strategy;

public class CleanTimeStrategy extends CalendarTimeStrategy {

    protected Integer workingDays() {
        return 248; // TODO: calculate real working days
    }
}
