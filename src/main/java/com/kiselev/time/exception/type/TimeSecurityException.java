package com.kiselev.time.exception.type;

import com.kiselev.time.exception.TimeException;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class TimeSecurityException extends TimeException {

    private HttpStatus httpStatus;

    public TimeSecurityException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
