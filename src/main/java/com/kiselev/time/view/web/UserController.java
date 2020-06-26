package com.kiselev.time.view.web;

import com.kiselev.time.model.constants.NavigationConstants.UserConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/user")
    public String user() {
        return UserConstants.USER;
    }
}
