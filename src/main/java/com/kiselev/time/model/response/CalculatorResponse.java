package com.kiselev.time.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CalculatorResponse {

    private Long calendarDate;

    private Long calendarTime;

    private Long cleanTime;

    private Double percents;
}
