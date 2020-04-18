package com.kiselev.time.view.web;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.constants.NavigationConstants;
import com.kiselev.time.model.constants.NavigationConstants.LoginConstants;
import com.kiselev.time.model.dto.db.Profile;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private static final String PROFILE_KEY = "profile";

    private final AuthenticationService authenticationService;

    @GetMapping("/login")
    public String login(Model model) {
        if (authenticationService.isLoggedInIn()) {
            return NavigationConstants.RegistrationConstants.TO_MENU;
        }

        Profile profile = new Profile();
        model.addAttribute(PROFILE_KEY, profile);
        return LoginConstants.LOGIN;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Profile profile) throws TimeException {
        authenticationService.login(profile);
        return LoginConstants.TO_MENU;
    }

    @PostMapping("/login/anonymous")
    public String loginAnonymously(@ModelAttribute Profile profile) throws TimeException {
        authenticationService.loginAnonymously(profile);
        return LoginConstants.TO_MENU;
    }
}
