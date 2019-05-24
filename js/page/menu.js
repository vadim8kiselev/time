$(document).ready(function () {

    // Open menu
    $('.toggler').click(function () {
        $('.menu').toggleClass('menu-open');
        $(this).toggleClass('toggler-active');
    });

    // If 'Change salary' was requested, open the dialog
    $('#edit-profile').click(function () {
        $.removeCookie('salary');
        to_entry();
    });


    let calculator_money = $('#calculator-money');
    calculator_money.change(function() {
        let money = calculator_money.val() - 0;

        if (money <= 0) {
            $('#calculator-time').val('');
            return false;
        }

        let salary = ($.cookie('salary') - 0) * 0.87;
        let working_hours = $.cookie('working_hours') - 0;

        let money_per_second = salary * Constant.months() / Constant.days() / working_hours / Constant.hours_in_seconds();

        let seconds_to_buy = money / money_per_second;


        $('#calculator-time').val(time_from_seconds(seconds_to_buy));
    });
});

function to_entry() {
    window.location = 'index.html';
}

