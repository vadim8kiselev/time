const Constant = (function () {

    const working_days_table = {
        2019: 247
    };

    return {
        year_in_seconds: function () {
            let working_hours = $.cookie('working_hours') - 0;
            return 60 * 60 * working_hours * 365;
        },

        day_in_seconds: function () {
            let working_hours = $.cookie('working_hours') - 0;
            return 60 * 60 * working_hours;
        },

        hours_in_seconds: function () {
            return 60 * 60;
        },

        minutes_in_seconds: function () {
            return 60;
        },

        months: function () {
            return 12;
        },

        days: function () {
            return working_days_table[new Date().getFullYear()];
        }
    }
}());
