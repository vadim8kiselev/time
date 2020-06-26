package com.kiselev.time.view.web;

import com.kiselev.time.function.balance.WorkLifeBalanceService;
import com.kiselev.time.function.calculator.CalculatorService;
import com.kiselev.time.function.day.DayTimeService;
import com.kiselev.time.function.usage.UsageCostService;
import com.kiselev.time.model.constants.NavigationConstants;
import com.kiselev.time.model.response.CalculatorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/function")
@RequiredArgsConstructor
public class FunctionController {

    private final CalculatorService calculatorService;

    private final DayTimeService dayTimeService;

    private final UsageCostService usageService;

    private final WorkLifeBalanceService balanceService;

    @GetMapping("/calculator")
    public String calculator() {
        return NavigationConstants.CalculatorConstants.CALCULATOR;
    }

    @ResponseBody
    @GetMapping("/calculator/calculate")
    public CalculatorResponse calculate(@RequestParam("price") Long price) {
        return calculatorService.calculateTime(
                price
        );
    }

    @GetMapping("/day")
    public String day() {
        return NavigationConstants.DayTimeConstants.DAY;
    }

    @GetMapping("/usage")
    public String usage() {
        return NavigationConstants.UsageCostConstants.USAGE;
    }

    @GetMapping("/balance")
    public String balance() {
        return NavigationConstants.WorkLifeBalanceConstants.BALANCE;
    }
}
