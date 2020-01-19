const Calculator = (function () {

    const menu_open_class = 'menu-open',
          toggler_active_class = 'toggler-active';

    return {
        initialize: function () {
            let toggler = $('.toggler'),
                menu = $('.menu'),
                edit_profile = $('#edit-profile'),
                calculator_money = $('#calculator-money'),
                calculator_time = $('#calculator-time');

            // Open menu
            toggler.click(function () {
                menu.toggleClass(menu_open_class);
                toggler.toggleClass(toggler_active_class);
            });

            // If 'Change salary' was requested, open the dialog
            edit_profile.click(function () {
                Cookie.clean();
                Navigation.to_entry();
            });

            calculator_money.change(function () {
                let money = calculator_money.val() - 0;

                if (money <= 0) {
                    calculator_time.val('');
                    return false;
                }

                let salary = (Cookie.get_salary() - 0) * Constant.tax();
                // let working_hours = Cookie.get_working_hours() - 0;

                let money_per_second = salary * Constant.months() / Constant.days() / Constant.hours() / Constant.minutes() / Constant.seconds();

                let seconds_to_buy = money / money_per_second;

                calculator_time.val(Timer.convert(seconds_to_buy));
            });
        },
    }
}());

$(function() {
    let salary = Cookie.get_salary();
    if (typeof salary === 'undefined') {
        Navigation.to_entry();
    }
});

$(document).ready(function () {
    Calculator.initialize();
});

