package com.kiselev.time.view.web.controller;

import com.kiselev.time.model.constants.NavigationConstants.MenuConstants;
import com.kiselev.time.model.session.TimeSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

    private final TimeSession timeSession;

    public MenuController(TimeSession timeSession) {
        this.timeSession = timeSession;
    }

    @GetMapping("/menu")
    public String menu() {
        if (timeSession.hasNoProfile()) {
            return MenuConstants.TO_INDEX;
        }
        return MenuConstants.MENU;
    }
}
