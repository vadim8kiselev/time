package com.kiselev.time.view.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {

    @RequestMapping(value = {"/calculator"}, method = RequestMethod.GET)
    public String calculator() {
        return "calculator";
    }
}
