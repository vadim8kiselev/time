package com.kiselev.time.view.web;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.constants.NavigationConstants.RegistrationConstants;
import com.kiselev.time.model.dto.Profile;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private static final String PROFILE_KEY = "profile";

    private final AuthenticationService authenticationService;

    @GetMapping("/")
    public String registration(Model model) {
        Profile profile = new Profile();
        model.addAttribute(PROFILE_KEY, profile);
        return RegistrationConstants.INDEX;
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute Profile profile) throws TimeException {
        authenticationService.register(profile);
        return RegistrationConstants.TO_MENU;
    }
}
