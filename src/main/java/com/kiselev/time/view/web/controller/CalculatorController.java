package com.kiselev.time.view.web.controller;

import com.kiselev.time.model.response.CalculatorResponse;
import com.kiselev.time.model.session.TimeSession;
import com.kiselev.time.service.calculator.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private TimeSession timeSession;

    @GetMapping("/calculator")
    public String calculator() {
        return "calculator";
    }

    @ResponseBody
    @GetMapping("/calculator/calculate")
    public CalculatorResponse calculate(@RequestParam("price") Long price) {
        return calculatorService.calculateTime(timeSession.getProfile(), price);
    }
}
