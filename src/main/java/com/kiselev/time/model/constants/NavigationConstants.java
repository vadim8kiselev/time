package com.kiselev.time.model.constants;

public interface NavigationConstants {

    String REDIRECT = "redirect:";

    interface RegistrationConstants {

        String INDEX = "index";

        String TO_MENU = REDIRECT + "/menu";
    }

    interface LoginConstants {

        String LOGIN = "login";

        String TO_MENU = REDIRECT + "/menu";
    }

    interface MenuConstants {

        String MENU = "menu";
    }

    interface CalculatorConstants {

        String CALCULATOR = "calculator";
    }
}
