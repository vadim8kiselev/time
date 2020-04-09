package com.kiselev.time.view.web.controller;

import com.kiselev.time.model.constants.NavigationConstants.CalculatorConstants;
import com.kiselev.time.model.response.CalculatorResponse;
import com.kiselev.time.model.session.TimeSession;
import com.kiselev.time.service.calculator.CalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    private final TimeSession timeSession;

    private final CalculatorService calculatorService;

    public CalculatorController(TimeSession timeSession,
                                CalculatorService calculatorService) {
        this.timeSession = timeSession;
        this.calculatorService = calculatorService;
    }

    @GetMapping("/calculator")
    public String calculator() {
        if (timeSession.hasNoProfile()) {
            return CalculatorConstants.TO_INDEX;
        }
        return CalculatorConstants.CALCULATOR;
    }

    @ResponseBody
    @GetMapping("/calculator/calculate")
    public CalculatorResponse calculate(@RequestParam("price") Long price) {
        return calculatorService.calculateTime(timeSession.getProfile(), price);
    }
}
