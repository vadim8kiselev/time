package com.kiselev.time.view.web;

import com.kiselev.time.function.usage.UsageCostService;
import com.kiselev.time.model.constants.NavigationConstants.UsageCostConstants;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UsageCostController {

    private final AuthenticationService authenticationService;

    private final UsageCostService usageService;

    @GetMapping("/usage")
    public String usage() {
        return UsageCostConstants.USAGE;
    }
}
