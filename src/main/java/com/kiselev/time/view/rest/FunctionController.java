package com.kiselev.time.view.rest;

import com.kiselev.time.function.balance.WorkLifeBalanceService;
import com.kiselev.time.function.calculator.CalculatorService;
import com.kiselev.time.function.day.DayTimeService;
import com.kiselev.time.function.usage.UsageCostService;
import com.kiselev.time.model.response.CalculatorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rest/v1/time/function")
public class FunctionController {

    private final CalculatorService calculatorService;

    private final DayTimeService dayTimeService;

    private final UsageCostService usageService;

    private final WorkLifeBalanceService balanceService;

    @GetMapping("/calculator/calculate")
    public CalculatorResponse calculate(@RequestParam("price") Long price) {
        return calculatorService.calculateTime(
                price
        );
    }
}
