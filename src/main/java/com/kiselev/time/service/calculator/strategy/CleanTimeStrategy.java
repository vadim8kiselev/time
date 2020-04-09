package com.kiselev.time.service.calculator.strategy;

public class CleanTimeStrategy extends CalendarTimeStrategy {

    protected int daysInTargetPeriod() {
        return 247; // TODO: calculate real working days
    }
}
