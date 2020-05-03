package com.kiselev.time.view.web;

import com.kiselev.time.function.day.DayTimeService;
import com.kiselev.time.model.constants.NavigationConstants.DayTimeConstants;
import com.kiselev.time.service.authentication.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class DayTimeController {

    private final AuthenticationService authenticationService;

    private final DayTimeService dayTimeService;

    @GetMapping("/day")
    public String day() {
        return DayTimeConstants.DAY;
    }
}
