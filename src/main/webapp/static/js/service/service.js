const Constant = (function () {
    return {
        minutes: function () {
            return 60;
        },

        seconds: function () {
            return 60;
        },

        days: function () {
            return 365;
        },

        hours: function () {
            return 24;
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

    function seconds_to_interval(raw_seconds) {
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

    function seconds_to_date(seconds) {
        let date = new Date(seconds);
        return date.toLocaleDateString() + ' ' + date.toLocaleTimeString();
    }

    return {
        to_interval: seconds_to_interval,
        to_date: seconds_to_date
    }
}());

const Caller = (function () {
    function callFull(method, url, async, data, dataType, processData, contentType, success, error) {
        console.log(url);
        $.ajax({
            type: method,
            url: url,
            async: async,
            data: data,
            dataType: dataType,
            processData: processData,
            contentType: contentType,
            success: function (body) {
                success(body);
            },
            error: function (exception) {
                error(exception);
            }
        });
    }

    function call(method, url, data, dataType, success, error) {
        callFull(method, url, true, JSON.stringify(data), dataType, false, 'application/json', success, error);
    }

    function get(url, success, error) {
        call('GET', url, null, 'json', success, error);
    }

    function post(url, data, success, error) {
        call('POST', url, data, 'json', success, error);
    }

    function url(uri, parameters) {
        let url = 'http://localhost:8080/' + uri;
        if (parameters) {
            let urlParams = jQuery.param(parameters);
            url += (urlParams ? '?' + urlParams : '');
        }
        return url;
    }

    return {
        callFull: callFull,
        call: call,
        get: get,
        post: post,
        url: url
    }
}());

