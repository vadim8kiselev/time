package com.kiselev.time.view.web;

import com.kiselev.time.model.constants.NavigationConstants.MenuConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MenuController {

    @GetMapping("/menu")
    public String menu() {
        return MenuConstants.MENU;
    }
}
