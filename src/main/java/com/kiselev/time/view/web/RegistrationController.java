package com.kiselev.time.view.web;

import com.kiselev.time.exception.TimeException;
import com.kiselev.time.model.constants.NavigationConstants.RegistrationConstants;
import com.kiselev.time.model.dto.db.Profile;
import com.kiselev.time.model.dto.ui.UIProfile;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private static final String PROFILE_KEY = "uiProfile";

    private final AuthenticationService authenticationService;

    @GetMapping("/")
    public String registration(Model model) {
        if (authenticationService.isLoggedInIn()) {
            return RegistrationConstants.TO_MENU;
        }

        UIProfile uiProfile = new UIProfile();
        model.addAttribute(PROFILE_KEY, uiProfile);
        return RegistrationConstants.INDEX;
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute UIProfile uiProfile) throws TimeException {
        Profile profile = new Profile(uiProfile);
        authenticationService.register(profile);
        return RegistrationConstants.TO_MENU;
    }
}
