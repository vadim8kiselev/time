package com.kiselev.time.model.constants;

public interface NavigationConstants {

    String REDIRECT = "redirect:";

    interface IndexConstants {

        String INDEX = "index";

        String TO_INDEX = REDIRECT + "/";

        String TO_MENU = REDIRECT + "/menu";
    }

    interface MenuConstants {

        String MENU = "menu";

        String TO_INDEX = REDIRECT + "/";
    }

    interface CalculatorConstants {

        String CALCULATOR = "calculator";

        String TO_INDEX = REDIRECT + "/";
    }
}
