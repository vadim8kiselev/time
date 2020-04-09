package com.kiselev.time.view.web.controller;

import com.kiselev.time.model.constants.NavigationConstants.IndexConstants;
import com.kiselev.time.model.profile.Profile;
import com.kiselev.time.model.session.TimeSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    private static final String PROFILE_KEY = "profile";

    private final TimeSession timeSession;

    public IndexController(TimeSession timeSession) {
        this.timeSession = timeSession;
    }

    @GetMapping("/")
    public String index(Model model) {
        if (timeSession.hasNoProfile()) {
            Profile profile = new Profile();
            model.addAttribute(PROFILE_KEY, profile);
            return IndexConstants.INDEX;
        } else {
            Profile profile = timeSession.getProfile();
            model.addAttribute(PROFILE_KEY, profile);
            return IndexConstants.TO_MENU;
        }
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        if (timeSession.hasNoProfile()) {
            return IndexConstants.TO_INDEX;
        } else {
            Profile profile = timeSession.getProfile();
            model.addAttribute(PROFILE_KEY, profile);
            return IndexConstants.INDEX;
        }
    }

    @PostMapping("/")
    public String index(Model model, @ModelAttribute Profile profile) {
        timeSession.setProfile(profile);
        model.addAttribute(PROFILE_KEY, profile);
        return IndexConstants.TO_MENU;
    }
}
