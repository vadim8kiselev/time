package com.kiselev.time.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorResponse {

    private Long calendarDate;

    private Long calendarTime;

    private Long cleanTime;

    private Double percents;
}
