const Calculator = (function () {

    const menu_open_class = 'menu-open',
          toggler_active_class = 'toggler-active';

    return {
        initialize: function () {
            let toggler = $('.toggler'),
                menu = $('.menu'),
                calculator_money = $('#calculator-money'),
                calculator_date = $('#calculator-date'),
                calculator_time = $('#calculator-time'),
                calculator_clean_time = $('#calculator-clean-time'),
                calculator_percents = $('#calculator-percents');

            // Open menu
            toggler.click(function () {
                menu.toggleClass(menu_open_class);
                toggler.toggleClass(toggler_active_class);
            });

            calculator_money.change(function () {
                let money = calculator_money.val() - 0;

                if (money <= 0) {
                    calculator_date.val('');
                    calculator_time.val('');
                    calculator_clean_time.val('');
                    calculator_percents.val('');
                    return false;
                }

                Caller.get(
                    Caller.url('/calculator/calculate', {"price": money}),
                    function (data) {
                        console.log(data);
                        calculator_date.val(Timer.to_date(data['calendarDate']));
                        calculator_time.val(Timer.to_interval(data['calendarTime']));
                        calculator_clean_time.val(Timer.to_interval(data['cleanTime']));
                        calculator_percents.val(data['percents'] + '%');
                    },
                    function (error) {
                        console.error(error);
                    }
                );

            });
        },
    }
}());

$(document).ready(function () {
    Calculator.initialize();
});

