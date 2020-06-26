package com.kiselev.time.view.web;

import com.kiselev.time.model.constants.NavigationConstants.LoginConstants;
import com.kiselev.time.model.dto.db.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private static final String PROFILE_KEY = "profile";

    @GetMapping("/login")
    public String login(Model model) {
        Profile profile = new Profile();
        model.addAttribute(PROFILE_KEY, profile);
        return LoginConstants.LOGIN;
    }
}
