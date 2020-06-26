package com.kiselev.time.view.web;

import com.kiselev.time.model.constants.NavigationConstants.RegistrationConstants;
import com.kiselev.time.model.dto.ui.UIProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private static final String PROFILE_KEY = "uiProfile";

    @GetMapping("/")
    public String registration(Model model) {
        UIProfile uiProfile = new UIProfile();
        model.addAttribute(PROFILE_KEY, uiProfile);
        return RegistrationConstants.INDEX;
    }
}
