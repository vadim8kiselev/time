package com.kiselev.time.view.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebViewController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = {"/menu"}, method = RequestMethod.GET)
    public String menu() {
        return "menu";
    }

    @RequestMapping(value = {"/calculator"}, method = RequestMethod.GET)
    public String calculator() {
        return "calculator";
    }
}
