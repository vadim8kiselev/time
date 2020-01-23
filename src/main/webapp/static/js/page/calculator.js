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

                Caller.get(
                    Caller.url('/calculator/calculate', {"price": money}),
                    function (data) {
                        console.log(data);
                        calculator_time.val(Timer.convert(data['calendar_time']));
                    },
                    function (error) {
                        console.error(error);
                    }
                );

            });
        },
    }
}());

$(function () {
    let salary = Cookie.get_salary();
    if (typeof salary === 'undefined') {
        Navigation.to_entry();
    }
});

$(document).ready(function () {
    Calculator.initialize();
});

