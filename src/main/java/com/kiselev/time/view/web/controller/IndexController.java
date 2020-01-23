package com.kiselev.time.view.web.controller;

import com.kiselev.time.model.profile.Profile;
import com.kiselev.time.model.session.TimeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

    @Autowired
    private TimeSession timeSession;

    @GetMapping("/")
    public String index(Model model) {
        Profile profile = timeSession.hasNoProfile()
                ? new Profile()
                : timeSession.getProfile();
        model.addAttribute("profile", profile);
        return "index";
    }

    @PostMapping("/")
    public String index(Model model, @ModelAttribute Profile profile) {
        timeSession.setProfile(profile);
        model.addAttribute("profile", profile);
        return "menu";
    }
}
