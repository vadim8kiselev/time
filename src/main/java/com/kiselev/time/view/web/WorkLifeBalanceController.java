package com.kiselev.time.view.web;

import com.kiselev.time.function.balance.WorkLifeBalanceService;
import com.kiselev.time.model.constants.NavigationConstants.WorkLifeBalanceConstants;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class WorkLifeBalanceController {

    private final AuthenticationService authenticationService;

    private final WorkLifeBalanceService balanceService;

    @GetMapping("/balance")
    public String balance() {
        return WorkLifeBalanceConstants.BALANCE;
    }
}
