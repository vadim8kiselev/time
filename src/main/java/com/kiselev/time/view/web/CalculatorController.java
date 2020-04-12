package com.kiselev.time.view.web;

import com.kiselev.time.function.calculator.CalculatorService;
import com.kiselev.time.model.constants.NavigationConstants.CalculatorConstants;
import com.kiselev.time.model.response.CalculatorResponse;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class CalculatorController {

    private final AuthenticationService authenticationService;

    private final CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String calculator() {
        return CalculatorConstants.CALCULATOR;
    }

    @ResponseBody
    @GetMapping("/calculator/calculate")
    public CalculatorResponse calculate(@RequestParam("price") Long price) {
        return calculatorService.calculateTime(
                authenticationService.profile(),
                price
        );
    }
}
