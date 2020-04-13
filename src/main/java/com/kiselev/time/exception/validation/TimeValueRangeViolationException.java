package com.kiselev.time.exception.validation;

import com.kiselev.time.exception.type.TimeFieldException;

public class TimeValueRangeViolationException extends TimeFieldException {

    public TimeValueRangeViolationException() {
    }

    public TimeValueRangeViolationException(String message) {
        super(message);
    }
}
