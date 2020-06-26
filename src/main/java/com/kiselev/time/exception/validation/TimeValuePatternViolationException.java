package com.kiselev.time.exception.validation;

import com.kiselev.time.exception.type.TimeFieldException;

public class TimeValuePatternViolationException extends TimeFieldException {

    public TimeValuePatternViolationException() {
    }

    public TimeValuePatternViolationException(String message) {
        super(message);
    }
}
