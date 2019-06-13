const Constant = (function () {

    /*const working_days_table = {
        2019: 247
    };*/

    return {

        minutes: function () {
            return 60;
        },

        seconds: function () {
            return 60;
        },

        months: function () {
            return 12;
        },

        days: function () {
            return 365;
        },

        hours: function () {
            return 24;
        },

        tax: function () {
            return 0.87;
        }
    }
}());

const Cookie = (function () {

    const salary_key = 'salary',
          working_hours_key = 'working_hours';

    function get_cookie(key) {
        return $.cookie(key);
    }

    function set_cookie(key, value) {
        $.cookie(key, value, {expires: 365});
    }

    function remove_cookie(key) {
        $.removeCookie(key);
    }

    return {
        set_salary: function (salary) {
            set_cookie(salary_key, salary);
        },

        get_salary: function () {
            return get_cookie(salary_key);
        },

        /*set_working_hours: function (working_hours) {
            set_cookie(working_hours_key, working_hours);
        },

        get_working_hours: function () {
            return get_cookie(working_hours_key);
        },*/

        clean: function () {
            remove_cookie(salary_key);
            //remove_cookie(working_hours_key);
        }
    }
}());

const Validate = (function () {

    function validate_is_salary(value) {
        return /^[1-9]\d*$/.test(value);
    }

    return {
        is_salary: validate_is_salary,
    }

}());

const Timer = (function () {

    const year = Constant.days() * Constant.hours() * Constant.minutes() * Constant.seconds(),
          day = Constant.hours() * Constant.minutes() * Constant.seconds(),
          hour = Constant.minutes() * Constant.seconds(),
          minute = Constant.seconds();

    function convert_seconds(raw_seconds) {
        raw_seconds = Math.round(raw_seconds);

        let time = '';

        if ((raw_seconds / year) >= 1) {
            let years = Math.floor(raw_seconds / year);
            time += years_to_time(years);
            raw_seconds %= years * year;
        }

        if ((raw_seconds / day) >= 1) {
            let days = Math.floor(raw_seconds / day);
            time += days_to_time(days);
            raw_seconds %= days * day;
        }

        if ((raw_seconds / hour) >= 1) {
            let hours = Math.floor(raw_seconds / hour);
            time += hours_to_time(hours);
            raw_seconds %= hours * hour;
        }

        if ((raw_seconds / minute) >= 1) {
            let minutes = Math.floor(raw_seconds / minute);
            time += minutes_to_time(minutes);
            raw_seconds %= minutes * minute;
        }

        if (raw_seconds > 0) {
            time += seconds_to_time(raw_seconds);
        }

        if (time === '') {
            time = '0 seconds'; // ?
        }

        return $.trim(time);
    }

    function years_to_time(years) {
        return years + ' year' + plural(years);
    }

    function days_to_time(days) {
        return days + ' day' + plural(days);
    }

    function hours_to_time(hours) {
        return hours + ' hour' + plural(hours);
    }

    function minutes_to_time(minutes) {
        return minutes + ' minute' + plural(minutes);
    }

    function seconds_to_time(seconds) {
        return seconds + ' second' + plural(seconds);
    }

    function plural(number) {
        return number !== 1 ? 's ' : ' ';
    }

    return {
        convert: convert_seconds
    }

}());

const Navigation = (function () {

    function navigate_to_entry() {
        navigate('index.html');
        return false;
    }

    function navigate_to_menu() {
        navigate('menu.html');
        return false;
    }

    function navigate_to_calculator() {
        navigate('calculator.html');
        return false;
    }

    function navigate(page) {
        window.location = page;
    }

    return {
        to_entry: navigate_to_entry,
        to_menu: navigate_to_menu,
        to_calculator: navigate_to_calculator
    }
}());


